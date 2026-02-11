import io.jsonwebtoken.Jwts;
import org.example.np.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.crypto.SecretKey;

public class Test {
    public static void main(String[] args) {
        SecretKey key = Jwts.SIG.HS256.key().build();
        System.out.println("this :"+ key.toString());
    }
}
