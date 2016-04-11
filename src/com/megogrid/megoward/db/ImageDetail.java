package com.megogrid.megoward.db;


/**
 * Created by divya on 11/2/16.
 */
public class ImageDetail{
    public ImageDetail(String id, String icon, String imagename,
                       String effectname, String imagecapturedate) {
        super();
        this.id = id;
        this.icon = icon;
        this.imagename = imagename;
        this.effectname = effectname;
        this.imagecapturedate = imagecapturedate;
    }

    public ImageDetail() {

    }

    private String id;
    private String icon;
    private String imagename;
    private String effectname;
    private String imagecapturedate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getEffectname() {
        return effectname;
    }

    public void setEffectname(String effectname) {
        this.effectname = effectname;
    }

    public String getImagecapturedate() {
        return imagecapturedate;
    }

    public void setImagecapturedate(String imagecapturedate) {
        this.imagecapturedate = imagecapturedate;
    }

    @Override
    public String toString() {
//        Gson gson = new Gson();
//        return gson.toJson(this);
        return "";
    }
}
