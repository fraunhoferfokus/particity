package de.particity.model.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.particity.model.I_OfferModel;
import de.particity.model.impl.Address;
import de.particity.model.impl.Offer;
import de.particity.model.map.OfferMapper;

@Repository
@Transactional
@MappingConfig(OfferMapper.class)
public abstract class OfferRepository extends AbstractEntityRepository<I_OfferModel, Long> { //extends EntityRepository<I_OfferModel, Long> {

	
	//@Query("select count(p) from Person p where p.age > ?1")
    //Long countAllOlderThan(int minAge);
    

    //@Query("select p from Person p where p.age between ?1 and ?2")
    //QueryResult<Person> findAllByAge(int minAge, int maxAge);
	
	//    List<Person> findByLastNameLikeOrderByAgeAscLastNameDesc(String lastName);
	
	//    List<Person> findAllOrderByAgeAsc();
	
	//    List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//@Query(named = Person.BY_MIN_AGE)
    //Long countAllOlderThan(int minAge);
	
	public abstract void removeById(long id);

	public abstract List<I_OfferModel> findAllOrderByPublishDesc(@FirstResult int start, @MaxResults int pageSize);

	@Query(named=Offer.getByCategoryEntries,isNative=true)
	public abstract List<I_OfferModel> findByCategoryEntries(E_OfferStatus status, LocalDateTime published, LocalDateTime expires, String entryIds, @FirstResult int start, @MaxResults int pageSize);
	
	@Query(named=Offer.getByCategoryEntries,isNative=true)
	public abstract List<I_OfferModel> findByCategoryEntries(E_OfferStatus status, LocalDateTime published, LocalDateTime expires, String entryIds);

	@Query(named=Offer.countByCategoryEntries,isNative=true)
	public abstract int countByCategoryEntries(E_OfferStatus status, LocalDateTime time,
			LocalDateTime time2, String categoryEntriesStr);

	@Query(named=Offer.getByCategories,isNative=true)
	public abstract List<I_OfferModel> findByCategories(E_OfferStatus status, LocalDateTime published, LocalDateTime expires, String catIds, @FirstResult int start, @MaxResults int pageSize);

	@Query(named=Offer.countByCategories,isNative=true)
	public abstract int countByCategories(E_OfferStatus status, LocalDateTime time,
			LocalDateTime time2, String categoriesStr);
	
	@Query(named=Offer.getByTypes,isNative=true)
	public abstract List<I_OfferModel> findByTypes(E_OfferStatus status, LocalDateTime published, LocalDateTime expires, String typesStr, @FirstResult int start, @MaxResults int pageSize);

	@Query(named=Offer.countByTypes,isNative=true)
	public abstract int countByTypes(E_OfferStatus status, LocalDateTime time, LocalDateTime time2, String typesStr);
	
	public abstract int countByStatusAndOrganization_id(E_OfferStatus status, long id);

	public abstract int countByStatus(E_OfferStatus status);

	public abstract List<I_OfferModel> findByAddress_id(long id);
	
	public abstract int countByAddress_id(long id);
	
	public abstract List<I_OfferModel> findByStatusAndOrganization_idOrderByPublishDesc(E_OfferStatus status, long id, @FirstResult int start, @MaxResults int pageSize);
	
	public abstract List<I_OfferModel> findByStatusOrderByPublishDesc(E_OfferStatus status, @FirstResult int start, @MaxResults int pageSize);

	public List<I_OfferModel> findByVarious(String items, String types,
			long orgId, Float lat, Float lon, Integer dist, int from, int to) {
		return typedQuery(getOfferByTypesAndItemsAndOrgSQL(types, items, orgId, lat, lon, dist)).setFirstResult(from).setMaxResults(to-from).getResultList();
	}

	public int countByVarious(String items, String types,
			long orgId, Float lat, Float lon, Integer dist) {
		
		String sql = "select count(*) as COUNT_VALUE from ("+getOfferByTypesAndItemsAndOrgSQL(types, items, orgId, lat, lon, dist)+") x";
		return ((Long) entityManager().createNativeQuery(sql, Integer.class).getSingleResult()).intValue();
	}

	
	private String getOfferByTypesAndItemsAndOrgSQL(String types, String categories, long orgId, Float lat, Float lon, Integer dist) {
		
		if (categories != null && categories.trim().length() == 0)
			categories = null;
		if (types != null && types.trim().length() == 0)
			types = null;
		
		if (types != null) {
			types = types.trim();
			if (types.startsWith(","))
				types = types.substring(1);
			if (types.endsWith(","))
				types = types.substring(0, types.length()-1);
			if (types.length() == 0)
				types = null;
		}
		
		if (categories != null) {
			categories = categories.trim();
			if (categories.startsWith(","))
				categories = categories.substring(1);
			if (categories.endsWith(","))
				categories = categories.substring(0, categories.length()-1);
			if (categories.length() == 0)
				categories = null;
		}
		
		String sql = "select offer.* from "+Offer.TABLE+" offer ";
		if (categories != null)
			sql+= " INNER JOIN PARTICITY_offer_citm map ON map.offerId=offer.id";
		
		if (lat != null && lon != null && lat != 0 && lon != 0 && dist != null && dist > 0) {
			sql+= " INNER JOIN "+Address.TABLE+" addr ON offer.adressId=addr.id";
		}
		
		sql+=" WHERE offer.status=? AND offer.publish <= ? AND offer.expires > ?";
		if (orgId >= 0) {
			sql+=" AND offer.orgId="+orgId;
		}
		if (categories != null)
			sql+=" AND map.itemId IN ("+categories+")";
		if (types != null && types.trim().length() > 0) {
			sql+= " AND offer.type_ IN ("+types+")";
		}
		if (lat != null && lon != null && lat != 0 && lon != 0 && dist != null && dist > 0) {
			sql+=" AND ((ACOS(SIN("+lat+" * PI() / 180) * SIN(addr.coordLat * PI() / 180) + "
					+ "COS("+lat+" * PI() / 180) * COS(addr.coordLat * PI() / 180) * COS(("+lon+" - addr.coordLon) * PI() / 180)) * 180 / PI())"
					+" * 60 * 1.852) <= "+dist;
		}
		if (categories != null)
			sql+=" GROUP BY offer.id";
		sql+=" ORDER by offer.updated";
		
		return sql;
	}

	@Query(named=Offer.getByExpiredAndOrg,isNative=true)
	public abstract List<I_OfferModel> findByExpiresAndOrgId(long id, long minExpired, long now);
	
	@Query(named=Offer.getByIssuerTime,isNative=true)
	public abstract List<I_OfferModel> findByIssuerTime(E_OfferStatus status, long minPublish, long maxPublish, long minExpires);

	abstract public I_OfferModel findFirstByOrg_idAndPublishLessThanOrderByPublishDesc(
			long id, long publish);
}
