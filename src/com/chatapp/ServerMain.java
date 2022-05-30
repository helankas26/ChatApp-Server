
import com.chatapp.dao.ChatDAO;
import com.chatapp.dao.UserDAO;
import com.chatapp.pojos.Chat;
import com.chatapp.pojos.User;
import java.rmi.RemoteException;
import java.time.Instant;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helanka
 */
public class ServerMain {
    public static void main(String[] args) throws RemoteException {
        
//        c.setChatId(1);
//        c.setName("zzz");
//        c.setDescription("sds ds  zzdsds");
//        c.setStatus(0);
//        c.setCreatedAt(Date.from(Instant.now()));
//        
//        ChatDAO d = new ChatDAO();
//        d.deleteChat(c);
//       
        User n = new User();
        n.setUserId(1);
        System.out.println(new UserDAO().getUser(n));

        System.exit(0);
    }
}
