package com.avansb.smartfarm.gasmodule;

public class GasModuleModel {

    String moduleNaam, moduleDatum;
    Integer moduleId, ppmWaarde;

    public GasModuleModel(Integer moduleId, String moduleNaam, Integer ppmWaarde, String moduleDatum) {
        this.moduleId = moduleId;
        this.moduleNaam = moduleNaam;
        this.ppmWaarde = ppmWaarde;
        this.moduleDatum = moduleDatum;
    }

    public String getModuleNaam() {
        return moduleNaam;
    }

    public void setModuleNaam(String moduleNaam) {
        this.moduleNaam = moduleNaam;
    }

    public String getModuleDatum() {
        return moduleDatum;
    }

    public void setModuleDatum(String moduleDatum) {
        this.moduleDatum = moduleDatum;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getPpmWaarde() {
        return ppmWaarde;
    }

    public void setPpmWaarde(Integer ppmWaarde) {
        this.ppmWaarde = ppmWaarde;
    }
}
