package panawaapps.pantaupilkada.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.URLs.GlobalVariable;
import twitter4j.HttpResponse;

public class MasukActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btn_daftar, btn_masuk;
//    UserLocalStore userLocalStore;


    //Constructor
    private static final String TAG = MasukActivity.class.getSimpleName();
    String Verify="3e82cf4114ed9897ec61d6cc38b2ec5436502c2f7ea954f56920fe35b0891b23e6041d6778635fcdb60be440423305cbc2778b6c8c6a9624825e9cd7d5ea930c";
    String name = null;
    String provider_uuid = null;
    String access_token = null;
    String provider = null;
    String emailid = "",key,status;
    String tok;
    Object value;

    /* A reference to the Firebase */
    private Firebase mFirebaseRef;

    /* Listener for Firebase session changes */
    private Firebase.AuthStateListener mAuthStateListener;


    /* Data from the authenticated user */
    private AuthData mAuthData;
    JSONObject json;
    ProgressDialog pDialog;
    EditText email,password;
    Button login,register;
    String responseServer;
    TextView bMasuk,bDaftar;
    public static String AuthCode;


    /* TextView that is used to display information about the logged in user */
    private TextView mLoggedInStatusTextView;
    /* A dialog that is presented until the Firebase authentication finished. */
    private ProgressDialog mAuthProgressDialog;
        /* The login button for Facebook */
    private LoginButton mFacebookLoginButton;
    /* The callback manager for Facebook */
    private CallbackManager mFacebookCallbackManager;
    /* Used to track user logging in/out off Facebook */
    private AccessTokenTracker mFacebookAccessTokenTracker;


    //TWITTER
    public static final int RC_TWITTER_LOGIN = 2;

    private Button mTwitterLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_masuk);


        email = (EditText) findViewById(R.id.etNamaUser);
        password = (EditText) findViewById(R.id.etPasswordUser);

        btn_daftar = (TextView)findViewById(R.id.bDaftar);
        btn_masuk = (TextView) findViewById(R.id.bMasuk);
//
//        btn_daftar.setOnClickListener(this);
//        btn_masuk.setOnClickListener(this);

        Verify= Verify.toString();

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(MasukActivity.this);
        String auth_token_string = settings.getString("token", "");
        if (!Objects.equals(auth_token_string, "")){
            Intent intent = new Intent(MasukActivity.this, HomeActivity.class);
            startActivity(intent);
        }



        findViewById(R.id.bDaftar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 TODO Auto-generated method stub
                Intent reg = new Intent(MasukActivity.this, DaftarActivity.class);
                startActivity(reg);
            }
        });


//        bDaftar.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent reg = new Intent(MasukActivity.this, DaftarActivity.class);
//                startActivity(reg);
//            }
//        });

        findViewById(R.id.bMasuk).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (email.getText().toString().equalsIgnoreCase("") && (password.getText().toString().equalsIgnoreCase(""))) {
                    Toast.makeText(getApplicationContext(), "Email & Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else {
                    AsyncT asyncT = new AsyncT();
                    asyncT.execute();
                }
            }
        });


//        findViewById(R.id.bMasuk).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                 TODO Auto-generated method stub
//                Intent reg = new Intent(MasukActivity.this, HomeActivity.class);
//                startActivity(reg);
//            }
//        });

         /* Load the Facebook login button and set up the tracker to monitor access token changes */
//        mFacebookCallbackManager = CallbackManager.Factory.create();
//        mFacebookLoginButton = (LoginButton) findViewById(R.id.login_with_facebook);
//        mFacebookLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        mFacebookAccessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//                Log.i(TAG, "Facebook.AccessTokenTracker.OnCurrentAccessTokenChanged");
//                MasukActivity.this.onFacebookAccessTokenChange(currentAccessToken);
//            }
//        };



////        mTwitterLoginButton = (Button) findViewById(R.id.login_with_twitter);
//        mTwitterLoginButton.setOnClickListener
//                (new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        loginWithTwitter();
//                        AsyncTSocial asyncTsocial = new AsyncTSocial();
//                        asyncTsocial.execute();
//                    }
//                });


//        /* Create the Firebase ref that is used for all authentication with Firebase */
//        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
//
//        /* Setup the progress dialog that is displayed later when authenticating with Firebase */
//        mAuthProgressDialog = new ProgressDialog(this);
//        mAuthProgressDialog.setTitle("Loading");
//        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
//        mAuthProgressDialog.setCancelable(false);
//        mAuthProgressDialog.show();

//        mAuthStateListener = new Firebase.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(AuthData authData) {
//                mAuthProgressDialog.hide();
//                setAuthenticatedUser(authData);
//                AsyncTSocial asyncTsocial = new AsyncTSocial();
//                asyncTsocial.execute();
//            }
//        };


         /* Check if the user is authenticated with Firebase already. If this is the case we can set the authenticated
         * user and hide hide any login buttons */
//        mFirebaseRef.addAuthStateListener(mAuthStateListener);



//        //Ali method
//        SharedPreferences aa = PreferenceManager.getDefaultSharedPreferences(this);
//        String token = aa.getString("key", "");
//        Intent abcd = new Intent(MasukActivity.this, HomeActivity.class);
//        startActivity(abcd);
//        Toast.makeText(getApplicationContext(), token.toString(), Toast.LENGTH_SHORT).show();

    } //end OFF onCreate





//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // if user logged in with Facebook, stop tracking their token
//        if (mFacebookAccessTokenTracker != null) {
//            mFacebookAccessTokenTracker.stopTracking();
//        }
//
//        // if changing configurations, stop tracking firebase session.
//        mFirebaseRef.removeAuthStateListener(mAuthStateListener);
//    }


//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Map<String, String> options = new HashMap<String, String>();
//        if (requestCode == RC_TWITTER_LOGIN) {
//            options.put("oauth_token", data.getStringExtra("oauth_token"));
//            options.put("oauth_token_secret", data.getStringExtra("oauth_token_secret"));
//            options.put("user_id", data.getStringExtra("user_id"));
//            authWithFirebase("twitter", options);
//        } else {
//            /* Otherwise, it's probably the request by the Facebook login button, keep track of the session */
//            mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
//        }
//    }

//
//        private void authWithFirebase(final String provider, Map<String, String> options) {
//            if (options.containsKey("error")) {
//                showErrorDialog(options.get("error"));
//            } else {
//                mAuthProgressDialog.show();
//                if (provider.equals("twitter")) {
//                    // if the provider is twitter, we pust pass in additional options, so use the options endpoint
//                    mFirebaseRef.authWithOAuthToken(provider, options, new AuthResultHandler(provider));
//                } else {
//                    // if the provider is not twitter, we just need to pass in the oauth_token
//                    mFirebaseRef.authWithOAuthToken(provider, options.get("oauth_token"), new AuthResultHandler(provider));
//                }
//            }
//        }
//
//
//        private void setAuthenticatedUser(AuthData authData) {
//            if (authData != null) {
//
//                mFacebookLoginButton.setVisibility(View.GONE);
//                mTwitterLoginButton.setVisibility(View.GONE);
////                mLoggedInStatusTextView.setVisibility(View.VISIBLE);
//
//
//                //String uid = null;
//                if (authData.getProvider().equals("facebook")
//                        || authData.getProvider().equals("google")
//                        || authData.getProvider().equals("twitter")) {
//                    name = (String) authData.getProviderData().get("displayName");
//                    provider_uuid = authData.getUid();
//                    provider=authData.getProvider();
//                    access_token=authData.getToken();
//                    emailid = (String) authData.getProviderData().get("email");
//                    //change not know ?
//                    Verify=(String) authData.getProviderData().
//                     get("3e82cf4114ed9897ec61d6cc38b2ec5436502c2f7ea954f56920fe35b0891b23e6041d6778635fcdb60be440423305cbc2778b6c8c6a9624825e9cd7d5ea930c");
//
//                }
//
//                else {
//                    Log.e(TAG, "Invalid provider: " + authData.getProvider());
//                }
//
////                if (name != null) {
////                    mLoggedInStatusTextView.setText("Logged in as " + name + " (" + authData.getProvider() + ")");
////                }
//
//            } else {
//
//                mFacebookLoginButton.setVisibility(View.VISIBLE);
//                mTwitterLoginButton.setVisibility(View.VISIBLE);
//
//            }
//
//            this.mAuthData = authData;
//
//        }
//
//    /**
//     * Show errors to users
//     */
//    private void showErrorDialog(String message) {
//        new AlertDialog.Builder(this)
//                .setTitle("Error")
//                .setMessage(message)
//                .setPositiveButton(android.R.string.ok, null)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
//    }

//    /**
//     * Utility class for authentication results
//     */
//    private class AuthResultHandler implements Firebase.AuthResultHandler {
//
//        private final String provider;
//
//        public AuthResultHandler(String provider) {
//            this.provider = provider;
//        }
//
//        @Override
//        public void onAuthenticated(AuthData authData) {
//            mAuthProgressDialog.hide();
//            Log.i(TAG, provider + " auth successful");
//            setAuthenticatedUser(authData);
//        }
//
//        @Override
//        public void onAuthenticationError(FirebaseError firebaseError) {
//            mAuthProgressDialog.hide();
//            showErrorDialog(firebaseError.toString());
//        }
//    }

    //FACEBOOK_TOKEN

//    private void onFacebookAccessTokenChange(AccessToken token) {
//        if (token != null) {
//            mAuthProgressDialog.show();
//            mFirebaseRef.authWithOAuthToken("facebook", token.getToken(), new AuthResultHandler("facebook"));
//        } else {
//            // Logged out of Facebook and currently authenticated with Firebase using Facebook, so do a logout
//            if (this.mAuthData != null && this.mAuthData.getProvider().equals("facebook")) {
//                mFirebaseRef.unauth();
//                setAuthenticatedUser(null);
//            }
//        }
//    }
//
//
//    private void loginWithTwitter() {
//        startActivityForResult(new Intent(this, TwitterOAuthActivity.class), RC_TWITTER_LOGIN);
//    }


    //METHODE KANU

    class AsyncT extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MasukActivity.this);
            pDialog.setMessage("Authenticating...");
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://api.pantaubersama.com:80/api/sessions/login.json");
            String user = email.getText().toString();
            String pass = password.getText().toString();


            JSONObject json = new JSONObject();
            try {
                String show="";
                JSONObject jsonobj = new JSONObject();

                jsonobj.put("email", user);
                jsonobj.put("password", pass);

                show=jsonobj.toString();
                httppost.setHeader("Content-Type", "application/json");
                httppost.setEntity(new StringEntity(show.toString()));

                org.apache.http.HttpResponse response = httpclient.execute(httppost);
                InputStream inputStream = response.getEntity().getContent();
                InputStreamToStringExample str = new InputStreamToStringExample();
                responseServer = str.getStringFromInputStream(inputStream);
                Log.e("response", "response -----" + responseServer);
                JSONObject jobj = new JSONObject(responseServer);
                status=jobj.get("status").toString();
                Log.e("status",""+status );
                tok=jobj.get("data").toString();

                JSONObject jobj1 = new JSONObject(tok);

                Iterator<String> iter =jobj1 .keys();
                while (iter.hasNext()) {
                    key = iter.next();
                    Log.e("key", "" + key);

                    try {
                        String token = String.valueOf(jobj1.get(key));
                        SharedPreferences settings = PreferenceManager
                                .getDefaultSharedPreferences(MasukActivity.this);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("token", token);
                        editor.commit();

                    } catch (JSONException e) {
                        // Something went wrong!
                    }
                }


                /*GlobalVariable.Token = jobj1.getString("Token").toString();
                Log.e("Token",""+GlobalVariable.Token );*/


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pDialog.dismiss();
            if (status.equalsIgnoreCase("error")) {
                Toast.makeText(getApplicationContext(), "Pastikan kombinasi email & password benar !", Toast.LENGTH_LONG).show();
            } else {


                Intent i = new Intent(MasukActivity.this, HomeActivity.class);

                startActivity(i);
            }
        }
    }

//    class AsyncTSocial extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            pDialog = new ProgressDialog(MasukActivity.this);
//            pDialog.setMessage("Authenticating......");
//            pDialog.show();
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            DefaultHttpClient httpclient = new DefaultHttpClient();
//            HttpPost httppost = new HttpPost("http://api.pantaubersama.com:80/api/sessions/omniauth_callback.json");
//
//            JSONObject json = new JSONObject();
//            try {
//                String show="";
//                JSONObject jsonobj = new JSONObject();
//
//                /*jsonobj.put("Verify",Verify);
//                Log.e("Verify", "Verify-----" + Verify);*/
//                httppost.addHeader("Verify", Verify);
//                Log.e("Verify", "Verify-----" + Verify);
//                jsonobj.put("provider", provider);
//                Log.e("provider", "provider-----" + provider);
//                jsonobj.put("provider_uuid", provider_uuid);
//                Log.e("provider_uuid", "provider_uuid-----" + provider_uuid);
//                jsonobj.put("access_token", access_token);
//                Log.e("access_token", "access_token-----" + access_token);
//                jsonobj.put("email", emailid);
//                Log.e("email", "email-----" + emailid);
//
//                show = jsonobj.toString();
//                Log.e("show", "show-----" + show);
//
//                httppost.setHeader("Content-Type", "application/json");
//                httppost.setEntity(new StringEntity(show));
//
//
//                org.apache.http.HttpResponse response = httpclient.execute(httppost);
//                InputStream inputStream = response.getEntity().getContent();
//                InputStreamToStringExample str = new InputStreamToStringExample();
//                responseServer = str.getStringFromInputStream(inputStream);
//                Log.e("response", "response -----" + responseServer);
//                JSONObject jobj = new JSONObject(responseServer);
//                //status=jobj.get("status").toString();
//                //String tok=jobj.get("data").toString();
//                //Log.e("token",""+tok);
//                        /*JSONObject jobj1 = new JSONObject(tok);
//                        GlobalVariable.Token = jobj1.getString("Token").toString();
//                        Log.e("Token",""+GlobalVariable.Token );*/
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            pDialog.dismiss();
////            Toast.makeText(getApplicationContext(), "Not a Registered User and Password", Toast.LENGTH_LONG).show();
//                    /*if (status.equalsIgnoreCase("error")) {
//                        Toast.makeText(getApplicationContext(), "Not a Registered User and Password", Toast.LENGTH_LONG).show();
//                    } else {
//                        Intent i = new Intent(New_Facebook_Twitter_Activity.this, MainActivity.class);
//
//                        startActivity(i);
//                    }*/
//
//                    /*Intent i = new Intent(New_Facebook_Twitter_Activity.this, MainActivity.class);
//
//                    startActivity(i);*/
//        }
//    }
    public static class InputStreamToStringExample {

        public static void main(String[] args) throws IOException {

            // intilize an InputStream
            InputStream is =
                    new ByteArrayInputStream("file content..blah blah".getBytes());

            String result = getStringFromInputStream(is);

            System.out.println(result);
            System.out.println("Done");

        }

        // convert InputStream to String
        private static String getStringFromInputStream(InputStream is) {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sb.toString();
        }

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bMasuk:
//                User user = new User(null, null);
//
//                userLocalStore.storeUserData(user);
//                userLocalStore.setUserLoggedIn(true);

                startActivity(new Intent(this, HomeActivity.class));
                break;

            case R.id.bDaftar:
                startActivity(new Intent(this, DaftarActivity.class));
                break;
        }
    }
}
