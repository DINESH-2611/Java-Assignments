import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrainSchedule extends JFrame{
    private JPanel mainPanel;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JTextField adTime1;
    private JLabel text4;
    private JTextField aaTime1;
    private JLabel text5;
    private JTextField adTime2;
    private JLabel text6;
    private JLabel text7;
    private JLabel text8;
    private JLabel text9;
    private JLabel text10;
    private JLabel text11;
    private JLabel text12;
    private JLabel text13;
    private JLabel text14;
    private JTextField bdTime1;
    private JTextField baTime1;
    private JTextField bdTime2;
    private JTextField aaTime2;
    private JTextField baTime2;
    private JButton getNoOfTrains;

    private String[][] atrips=new String[2][2];
    private String[][] btrips=new String[2][2];

    public TrainSchedule() {getNoOfTrains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atrips[0][0]=adTime1.getText();
                atrips[0][1]=aaTime1.getText();
                atrips[1][0]=adTime2.getText();
                atrips[1][1]=aaTime2.getText();

                btrips[0][0]=bdTime1.getText();
                btrips[0][1]=baTime1.getText();
                btrips[1][0]=bdTime2.getText();
                btrips[1][1]=baTime2.getText();

                int[] res=noOftrains(atrips,btrips);
                if(res[0]==-1 || res[1]==-1)
                    JOptionPane.showMessageDialog(getNoOfTrains,"Invalid input");
                else
                    JOptionPane.showMessageDialog(getNoOfTrains,"Number of trains for station A is "+res[0]+"\nNumber of trains for station A is "+res[1]);
//                    JOptionPane.showMessageDialog(getNoOfTrains,bdTime1.getText());

            }
        });

    }

    public static void main(String[] args) {
        TrainSchedule t=new TrainSchedule();
        t.setContentPane(t.mainPanel);
        t.setTitle("Train");
//        t.setBounds(600,500,500,500);
         t.setSize(300,900);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






    }
    public static int[] noOftrains(String[][] aTrips,String[][] bTrips){
        List<Integer> depatureA = new ArrayList<Integer>();
        List<Integer> arrivalA = new ArrayList<Integer>();
        List<Integer> depatureB = new ArrayList<Integer>();
        List<Integer> arrivalB = new ArrayList<Integer>();
        int aCount=0,bCount=0;
        for (int i = 0; i < aTrips.length; i++) {
            int min1=toMinutes(aTrips[i][0]);
            int min2=toMinutes(aTrips[i][1]);
            if(min1 ==-1 || min2==-1)
                return new int[]{-1,-1};
            depatureA.add(min1);
            arrivalA.add(min2);
        }
        for (int i = 0; i < bTrips.length; i++) {
            int min1=toMinutes(bTrips[i][0]);
            int min2=toMinutes(bTrips[i][1]);
            if(min1 ==-1 || min2==-1)
                return new int[]{-1,-1};
            depatureB.add(min1);
            arrivalB.add(min2);
        }
        for (int i = 0; i < depatureA.size(); i++)
        {
            if(arrivalB.isEmpty()) {
                aCount=depatureA.size();
                break;
            }
            if(Collections.min(arrivalB)<depatureA.get(i))
            {
                arrivalB.remove(Collections.min(arrivalB));
                continue;
            }
            if(!depatureA.isEmpty() &&!(Collections.min(arrivalB)<depatureA.get(i)))
                aCount++;
        }
        for (int i = 0; i < depatureB.size(); i++) {
            if(arrivalA.isEmpty()) {
                bCount=depatureB.size();
                break;
            }
            if(Collections.min(arrivalA)<depatureB.get(i)){
                arrivalA.remove(Collections.min(arrivalA));
                continue;
            }
            if(!depatureB.isEmpty() &&  !(Collections.min(arrivalA)<depatureB.get(i)))
                bCount++;
        }
        int[] res={aCount,bCount};
        return res;
    }

    public static int toMinutes(String s) {
        if(s=="")
            return 0;
        String[] s1 = s.split(":");
        if (s1.length != 2)
            return -1;
        int hours=0,min=0;
        try {
            hours = Integer.parseInt(s1[0]);
            min = Integer.parseInt(s1[1]);
        }catch (NumberFormatException e){
            System.err.println("Enter time between  00:00 and 23:59 and only with digits");
            return -1;
        }
        if (hours < 0 || hours > 23 || min < 0 || min > 59)
            return -1;
        return hours * 60 + min;

    }


}

