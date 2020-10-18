package com.company;

public class SearchResult {

    private String tenantName;

    private String slingResourceSuperType;

    private boolean havingHtml;

    private boolean havingDialogue;

    private boolean havingSlingModel;

    private boolean havingClientLibrary;

    @Override
    public String toString() {
        return "SearchResult{" +
                "tenantName='" + tenantName + '\'' +
                ", slingResourceSuperType='" + slingResourceSuperType + '\'' +
                ", havingHtml=" + havingHtml +
                ", havingDialogue=" + havingDialogue +
                ", havingSlingModel=" + havingSlingModel +
                ", havingClientLibrary=" + havingClientLibrary +
                '}';
    }

    public SearchResult(String tenantName, String superResourceType, boolean havingCustomizedHtml, boolean havingCustomizedDialogue, boolean havingCustomizedSlingModel, boolean havingCustomizedClientLibrary) {
        this.tenantName = tenantName;
        this.slingResourceSuperType = superResourceType;
        this.havingHtml = havingCustomizedHtml;
        this.havingDialogue = havingCustomizedDialogue;
        this.havingSlingModel = havingCustomizedSlingModel;
        this.havingClientLibrary = havingCustomizedClientLibrary;
    }

    public SearchResult() {
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getSlingResourceSuperType() {
        return slingResourceSuperType;
    }

    public void setSlingResourceSuperType(String slingResourceSuperType) {
        this.slingResourceSuperType = slingResourceSuperType;
    }

    public boolean isHavingHtml() {
        return havingHtml;
    }

    public void setHavingHtml(boolean havingHtml) {
        this.havingHtml = havingHtml;
    }

    public boolean isHavingDialogue() {
        return havingDialogue;
    }

    public void setHavingDialogue(boolean havingDialogue) {
        this.havingDialogue = havingDialogue;
    }

    public boolean isHavingSlingModel() {
        return havingSlingModel;
    }

    public void setHavingSlingModel(boolean havingSlingModel) {
        this.havingSlingModel = havingSlingModel;
    }

    public boolean isHavingClientLibrary() {
        return havingClientLibrary;
    }

    public void setHavingClientLibrary(boolean havingClientLibrary) {
        this.havingClientLibrary = havingClientLibrary;
    }
}
