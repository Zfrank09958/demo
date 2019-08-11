package com.example.demo.model;

public class ControlModel {
    private Long id;

    private String uuid;

    private String widgetName;

    private String miHeight;

    private String miWidth;

    private String miX;

    private String miY;

    private String miParams;

    private String zindex;

    private String parentId;

    private String pageUuid;

    public ControlModel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName == null ? null : widgetName.trim();
    }

    public String getMiHeight() {
        return miHeight;
    }

    public void setMiHeight(String miHeight) {
        this.miHeight = miHeight == null ? null : miHeight.trim();
    }

    public String getMiWidth() {
        return miWidth;
    }

    public void setMiWidth(String miWidth) {
        this.miWidth = miWidth == null ? null : miWidth.trim();
    }

    public String getMiX() {
        return miX;
    }

    public void setMiX(String miX) {
        this.miX = miX == null ? null : miX.trim();
    }

    public String getMiY() {
        return miY;
    }

    public void setMiY(String miY) {
        this.miY = miY == null ? null : miY.trim();
    }

    public String getMiParams() {
        return miParams;
    }

    public void setMiParams(String miParams) {
        this.miParams = miParams == null ? null : miParams.trim();
    }

    public String getZindex() {
        return zindex;
    }

    public void setZindex(String zindex) {
        this.zindex = zindex == null ? null : zindex.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPageUuid() {
        return pageUuid;
    }

    public void setPageUuid(String pageUuid) {
        this.pageUuid = pageUuid == null ? null : pageUuid.trim();
    }
}