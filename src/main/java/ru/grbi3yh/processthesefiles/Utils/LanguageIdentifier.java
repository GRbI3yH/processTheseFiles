package ru.grbi3yh.processthesefiles.Utils;

public class LanguageIdentifier {

    public static final String RU = "ru";
    public static final String EN = "en";

    public String contextLanguage(){
        return java.awt.im.InputContext.getInstance().getLocale().getLanguage();
    }

//    public void identifier() {

//    Locale ru = new Locale("ru", "RU");
//    Locale en = new Locale("en", "US");
//
//        InputContext InCon = java.awt.im.InputContext.getInstance().getLocale().getLanguage();
//        if (InCon.getLocale().getLanguage().equals("en")) {
//            System.out.println("english lang detected");
//            boolean result = InCon.selectInputMethod(ru);
//            System.out.println(result);
//        } else {
//            System.out.println("russian lang detected");
//            InCon.selectInputMethod(en);
//        }
//    }

    // http://rsdn.org/forum/java/2494323.hot
    //        Locale ru = new Locale("ru", "RU");
    //        Locale en = new Locale("en", "US");
    //
    //        InputContext InCon = TextArea.getInputContext();
    //
    //        Locale h = InCon.getLocale();
    //        System.out.println("language=" + h.getLanguage());
    //
    //        boolean status = InCon.selectInputMethod(ru);
    //        System.out.println("status=" + status);
    //
    //        InputContext InCon1 = TextArea.InputContext();
    //
    //        Locale h1 = InCon1.getLocale();
    //        System.out.println("language=" + h1.getLanguage());

}
