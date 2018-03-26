package BeanOfAuto;

public  class AuthorityManager {
    public static boolean verifyAuthority(Staff s,int aut){
        if(!(s.authority<=aut)) {
            return false;
        }
        return true;
    }
}
