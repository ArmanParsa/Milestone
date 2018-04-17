package com.milestonee.milestone_project;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    static String value="",value1="",id="";//Variable Description
    static String genius[],uid[];
    static int datab=0;
    static EditText UserEmail, UserPassword;
    static  String item="",ufname="",ulname="";
    static TextView txtView;
    static ArrayList<String> arrayList;
    static ArrayAdapter<String> adapter;
    static ListView lv;
    static String[] sessions;
    static  String result="";
    static int num,lengthh;
    static int indexx=0;
    private ProgressDialog progress;//ProgressDialog for Async Task (Background Network related Processes)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UserEmail = (EditText) findViewById(R.id.editText);//Initialise UserEmail
        UserEmail.setText("arman7.parsa@gmail.com");//Set UserEmail to my ID
        UserPassword = (EditText) findViewById(R.id.editText2);//Initialise Userpassword
        UserPassword.setText("arman1234");//Set UserPassword to my Password
        try
        {
            ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE); // Connectivity Manager Object
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();//Call Object to check availability of Internet Connection
            if (activeNetwork == null) // If no Internet Connection
            {
               // txtView.setVisibility(View.VISIBLE);
                //txtView.setTextColor(Color.parseColor("#ff0000"));
               // txtView.setText("Please check your Internet Connection");
            }
            else if (activeNetwork.isConnected()) // If Internet Access Available
            {
                /*FirebaseDatabase database_5 = FirebaseDatabase.getInstance();//Firebase Object
                DatabaseReference myRef5 = database_5.getReference("Login");//Child specific object
                myRef5.child("I"+("1")).setValue("parth.prs.shah@gmail.com"+"§"+"parth1234"+"§"+"Parth"+"§"+"Shah"+"§"+"07858773873"+"§");//write data
                myRef5.child("I"+("2")).setValue("arman7.parsa@gmail.com"+"§"+"arman1234"+"§"+"Arman"+"§"+"Parsa"+"§"+"07858773873"+"§");
               // Toast.makeText(getBaseContext(),"Sucessfully Registered!",Toast.LENGTH_LONG).show();
//"Java§10 §2018/03/19 15:17:17§#arrays§Ishveer Degun§"
                FirebaseDatabase database_4 = FirebaseDatabase.getInstance();
                DatabaseReference myRef4 = database_4.getReference("Milestone");
                myRef4.child("parthprsshah").setValue("Final Year Project"+"§"+"10"+"§"+"2018/04/01 5:17:17"+"§"+"Task1"+"§"+"10"+"§");

                myRef4.child("arman7parsa").setValue("Milestone Project"+"§"+"3"+"§"+"2018/04/02 4:17:17"+"§"+"Task1"+"§"+"10"+"§");
                myRef4.child("arman7parsa").setValue("FYP Viva"+"§"+"10"+"§"+"2018/04/11 7:17:17"+"§"+"Task1"+"§"+"10"+"§");*/
            //    Toast.makeText(getBaseContext(),"Sucessfully Registered!",Toast.LENGTH_LONG).show();

                FirebaseDatabase database_b = FirebaseDatabase.getInstance();//Firebase Object
                final DatabaseReference myRefb = database_b.getReference("Login");//Child specific object
                myRefb.addListenerForSingleValueEvent(new ValueEventListener() { // value listener to get all data once in a go
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) // Through dataSnapShot
                    {
                        value1 = dataSnapshot.getValue().toString();//store all data in value1
                        System.out.println("Login ********************" + value1);// display result in console
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });


                try {
                    FirebaseDatabase database_b1 = FirebaseDatabase.getInstance();
                    final DatabaseReference myRefb1 = database_b1.getReference("Milestone");

                    myRefb1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {
                                value = dataSnapshot.getValue().toString();
                                System.out.println("***************************************"+value+"");
                            } catch (Exception dfd) {
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                        }
                    });
                } catch (Exception df) {}
            }
        } catch (Exception e) {}
    }

    @Override
    public void onClick(View v) {
        value1 = value1.substring(1, value1.length() - 1); // remove first and last character
        Scanner in = new Scanner(value1).useDelimiter("\\,"); //object "in" for scanner class created
        int count = 0;//initialise count to 0
        while (in.hasNext() == true) {
            datab++;
            String data = in.next();
            String ID = data.substring(data.indexOf("=") + 1, data.indexOf("§"));//Delimit user IDs
            System.out.println("***********************" + ID);//Display on console
            if (ID.equalsIgnoreCase(UserEmail.getText().toString()) == true) {//Check if user ID entered is correct
                count++;//If correct, count +1
                Scanner inn = new Scanner(data).useDelimiter("\\§");// Scanner "inn"
                int cc = 0;
                while (inn.hasNext() == true) {//Loop to check password
                    String details = inn.next();
                    if (cc == 1) {
                        if (details.equals(UserPassword.getText().toString()) == true) {
                            ufname = inn.next();
                            ulname = inn.next();
                            new HomeActivity.PostClass(this).execute();
                        } else {
                            //txtView.setVisibility(View.VISIBLE);
                            break;
                        }
                    }
                    cc++;
                }
                break;
            }
        }
        if (count == 0) {
           // txtView.setText("Wrong Email ID");
           // txtView.setVisibility(View.VISIBLE);
        }

    }





//Async task used to execute networking tasks and operations in background.

    class PostClass extends AsyncTask<String, Void, Void> {
        private final Context context;

        public PostClass(Context c) {
            this.context = c;
        }

        protected void onPreExecute() {
            progress = new ProgressDialog(this.context);
            progress.setMessage("Loading"); // Loading Sign while network executing queries.
            progress.show();
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT) // Minimum level KITKAT
        @Override
        protected Void doInBackground(String... params) {
            //{M1=Final Year Project§10§2018/04/01 5:17:17§Task1§10§, M2=Milestone Project§3§2018/04/02 4:17:17§Task1§10§}
            sessions=null;//Initialise Sessions to null
            arrayList = new ArrayList<String>();//Arraylist initialised
            adapter = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1, arrayList);//adapter created and initialised
            result=value;//store value in result
            //Get the session unique ID
            System.out.println("**********************************"+value+"");//display on console
            if(result.equals("")==false){ // check if result is not empty
                lengthh = 0;//length 0
                for (int i = 0; i < result.length(); i++) { // loop to get total milestone count in the database
                    char c = result.charAt(i);
                    if (c == ',') {
                        lengthh++;
                    }
                }
                num = 0;
                result = result.substring(1, result.length()-1); // remove the brackets which we get from the firebase database
                System.out.println("*********************"+result);//display updated results on console
                sessions = new String[++lengthh];//initialise array with total milestones
                //arman7parsa=Milestone Project§3§2018/04/02 4:17:17§Task1§10§, parthprsshah=Final Year Project§10§2018/04/01 5:17:17§Task1§10§
                Scanner in = new Scanner(result).useDelimiter("\\,");
                int neww=0;
                while (in.hasNext() == true) {// Whileloop to populate listview in the MainActivity or Home Page
                    String gen="";
                    String G = in.next();
                    G = G.trim();
                    if (G.length() != 0) {
                        id = G.substring(0, G.indexOf("="));
                        System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*"+id+"    "+""+getUserName(UserEmail.getText() + ""));
                        if (id.equals("" + getUserName(UserEmail.getText() + "")) == true) {
                            G = G.substring(G.indexOf("=") + 1, G.length() - 1);
                            Scanner innn = new Scanner(G).useDelimiter("\\§");
                            String itemm = "";
                            int count = 0;
                            while (innn.hasNext() == true) {
                                String P = innn.next();
                                if (count == 0) {
                                    gen += P + "§";
                                    itemm = "Milestone Name: " + P + "";
                                } else if (count == 1) {
                                    itemm += '\n' + "Time(Days): " + P + "";
                                } else if (count == 2) {
                                    itemm += '\n' + "Date: " + P + "";
                                } /*else if (count == 3) {
                                    itemm += '\n' + "Task " + P + "";
                                } else if (count == 4) {
                                    itemm += '\n' + "Time Frame" + id;
                                    gen += P + "§";
                                }*/
                                count++;
                            }
                            if (num < lengthh) {
                                sessions[num++] = G + "";
                                adapter.add(itemm + "");
                            }
                        }
                    }
                    //genius[neww++]=gen+"";
                }}
            adapter.notifyDataSetChanged();
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    progress.dismiss();
                }
            });
            return null;
        }
        protected void onPostExecute() {
            progress.dismiss();
        }
    }


    public void sendNotification() {

        //Get an instance of NotificationManager//

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");


        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // When you issue multiple notifications about the same type of event,
        // it’s best practice for your app to try to update an existing notification
        // with this new information, rather than immediately creating a new notification.
        // If you want to update this notification at a later date, you need to assign it an ID.
        // You can then use this ID whenever you issue a subsequent notification.
        // If the previous notification is still visible, the system will update this existing notification,
        // rather than create a new one. In this example, the notification’s ID is 001//

        mNotificationManager.notify(001, mBuilder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getUserName(String IDD)
    {
        String neww="";
        for(int i=0;i<IDD.length();i++)
        {
            char c=IDD.charAt(i);
            if(c=='@')
            {
                break;
            }
            else if(Character.isDigit(c)==true || Character.isAlphabetic(c)==true)
            {

                neww+=c+"";
            }
        }
        return neww;
    }
}
