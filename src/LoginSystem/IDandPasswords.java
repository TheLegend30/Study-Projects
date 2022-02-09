package LoginSystem;

import java.util.HashMap;

public class IDandPasswords {

    private HashMap<String, String> logininfo = new HashMap<>();

    public IDandPasswords() {
        logininfo.put("Kaizak","borsch");
        logininfo.put("blblb","buruburu");
        logininfo.put("something","stuff");
        logininfo.put("qwerty","123");
    }

    protected HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
}
