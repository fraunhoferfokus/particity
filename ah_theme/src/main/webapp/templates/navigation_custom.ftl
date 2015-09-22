<nav class="${nav_css_class} navbar navbar-default navbar-fixed-top" >
<div class="navbar-inner container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img alt="Brand" src="${site_logo}">
            </a>
          </div>
        <div id="navbar" class="nav-collapse navbar-collapse collapse" id="navigation" role="navigation">
        <ul id="youwontguesswhat" class="nav navbar-nav" aria-label="#language ("site-pages")" role="menubar" style="float: right !important;">
          <#list nav_items as nav_item>
                <#assign nav_item_attr_has_popup = "" />
                <#assign nav_item_attr_selected = "" />
                <#assign nav_item_css_class = "" />
                <#assign nav_item_url = nav_item.getURL() />
          
                <#if nav_item.isSelected()>
                  <#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
                  <#assign nav_item_attr_selected = "" />
                  <#assign nav_item_css_class = "selected" />
                </#if>

                       <#if nav_item.hasChildren()>
                               <#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
                               <#assign nav_item_css_class = "dropdown" />

                       </#if>

                        
                          <li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" ${nav_item_attr_selected} role="presentation">
  
  
                                  <#if nav_item.hasChildren()>
                                  <a aria-labelledby="layout_${nav_item.getLayoutId()}" id="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item_attr_has_popup} ${nav_item.getTarget()}  class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" role="button" aria-expanded="false">${nav_item.icon()} ${nav_item.getName()}<span class="caret"></span></a>
                                  
                                  <ul class="dropdown-menu" role="menu">
                                  <#list nav_item.getChildren() as nav_child>
                                     
                                      <#assign nav_child_attr_selected = "" />
                                      <#assign nav_child_css_class = "" />
                        
                                      <#if nav_item.isSelected()>
                                        <#assign nav_child_attr_selected = "" />
                                        <#assign nav_child_css_class = "selected" />
                                      </#if>
  
                                              <li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" ${nav_child_attr_selected} role="presentation">
                                                      <a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
                                              </li>
                                          </#list>
                                    </ul>
                                    
                                    <#else>
                                    
                                    <a aria-labelledby="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item_attr_has_popup} ${nav_item.getTarget()} role="menuitem"><span>${nav_item.icon()} ${nav_item.getName()}</span></a>                                  
                                  </#if>
                                  
                          </li>
                        
           </#list>
        </ul>
        </div>
        </div>
</nav>
