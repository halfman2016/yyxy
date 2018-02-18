package com.boteteam.yper.yyxy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boteteam.yper.yyxy.Module.GradeClass;
import com.boteteam.yper.yyxy.Module.Student;
import com.boteteam.yper.yyxy.Module.Teacher;
import com.boteteam.yper.yyxy.Student.stuMain;
import com.boteteam.yper.yyxy.Teacher.teaMain;
import com.boteteam.yper.yyxy.Utils.MDBTools;
import com.boteteam.yper.yyxy.Utils.MySqlTools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private MDBTools mdb=new MDBTools();
    //教师教授班级的列表  gces保存在教师 mongodb中
    private HashMap<GradeClass,String> gces=new HashMap<>();
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "t01:12345", "s01:12345"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mLoginName;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MyApplication myApplication=MyApplication.getInstance();

        // Set up the login form.
        mLoginName = (AutoCompleteTextView) findViewById(R.id.loginame);
      // populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Log.e("mydata", "onCreate: hahaha");



    }






    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mLoginName.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String loginame = mLoginName.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(loginame)) {
            mLoginName.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isEmailValid(loginame)) {
            mLoginName.setError(getString(R.string.error_invalid_loginame));
            focusView = mLoginFormView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(loginame, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
      //  return email.contains("@");
        return  true;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }



    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private  String mLoginame;
        private  String mPassword;
        private  Teacher teacher;
        private  Student student;

        UserLoginTask(String loginame, String password) {
            mLoginame = loginame;
            mPassword = password;
            student = null;
            teacher=null;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            //  tid 老师登录 sid 学生登录，从一开始区分
            String tmp=mLoginame.substring(0,1).toLowerCase();
            mLoginame=tmp+mLoginame.substring(1);
            boolean result=false;

            switch (tmp) {
                case "t":
                    result=mdb.teacherLogin(mLoginame,mPassword);
                    if (result) {

                        teacher = mdb.getTeacher(mLoginame);
                        //写科目数据
//                        HashMap<String,String> thm=new HashMap<>();
//                        GradeClass nowclass=mdb.getGradeClassIsActiveByName("九1班");
//
//                        thm.put(nowclass.get_id().toString(),"语文");
//                        nowclass=mdb.getGradeClassIsActiveByName("九2班");
//                        thm.put(nowclass.get_id().toString(),"数学");
//
//                        teacher.setGcs(thm);
//                        mdb.updateTeacher(teacher);
                        HashMap<String,String> gc=teacher.getGcs();
                        Iterator iter = gc.entrySet().iterator();
                        while (iter.hasNext()) {
                            HashMap.Entry entry = (HashMap.Entry) iter.next();
                        Object key = entry.getKey();
                        Object val = entry.getValue();
                            gces.put(mdb.getGradeClass(UUID.fromString((String) key)), (String) val);
                        }
                        return result;

                    }
                    break;
                case "s":
                    result=mdb.stuSidLogin(mLoginame,mPassword);
                    if (result) {

                        student = mdb.getStudentBySid(mLoginame);

                        return result;

                    }
                    break;
                default:

                    break;
            }
//            for (String credential : DUMMY_CREDENTIALS) {
//                String[] pieces = credential.split(":");
//                if (pieces[0].equals(mLoginame)) {
//                    // Account exists, return true if the password matches.
//                    return pieces[1].equals(mPassword);
//                }
//            }

            // TODO: register the new account here.
            // 登录成功


            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
                if ((mLoginame.substring(0,1).compareTo("t") * mLoginame.substring(0,1).compareTo("T"))==0)

                {

                    //写教师和教学配置
                    MyApplication myApplication=MyApplication.getInstance();
                    myApplication.setTeacher(teacher);
                    myApplication.setGcsubjects(gces);


                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, teaMain.class);
                    startActivity(intent);
                }
                else
                {
                    MyApplication myApplication=MyApplication.getInstance();
                    myApplication.setStudent(student);

                    //启动学生版
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, stuMain.class);
                    startActivity(intent);
                }

                } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

