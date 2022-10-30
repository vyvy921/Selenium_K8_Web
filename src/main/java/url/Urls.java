package url;

public interface Urls {
//    String demoBaseUrl = "http://demowebshop.tricentis.com";
    String demoBaseUrl = System.getProperty("baseUrl");
    String baseUrl = "https://the-internet.herokuapp.com";
    String loginSlug = "/login";
    String dropdownSlug = "/dropdown";
    String iframeSlug = "/iframe";
    String hoverSlug = "/hovers";
    String jsArlertSlug = "/javascript_alerts";
    String dynamicControlSlug = "/dynamic_controls";


}
