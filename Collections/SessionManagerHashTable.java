package Collections;


import java.util.Date;
import java.util.Hashtable;

public class SessionManagerHashTable {
    private Hashtable<String, Session> sessions;

    public SessionManagerHashTable() {
        sessions = new Hashtable<>();
    }

    public void createSession(String sessionId, String userName) {
        Session session = new Session(sessionId, userName);
        sessions.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
    private static class Session {
        private String sessionId;
        private String userName;
        private Date loginTime;

        public Session(String sessionId, String userName) {
            this.sessionId = sessionId;
            this.userName = userName;
            this.loginTime = new Date();
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public Date getLoginTime() {
            return loginTime;
        }
    }

    public static void main(String[] args) {
        SessionManagerHashTable sessionManager = new SessionManagerHashTable();

        sessionManager.createSession("123456", "Alice");

        Session session = sessionManager.getSession("123456");
        if (session != null) {
            System.out.println("Session ID: " + session.getSessionId());
            System.out.println("User Name: " + session.getUserName());
            System.out.println("Login Time: " + session.getLoginTime());
        }

        sessionManager.removeSession("123456");
    }
}
