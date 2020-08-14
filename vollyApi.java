package io.com.didingapp.Volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class VolleyApi {

    public static final String BASE_URL = "http://192.168.43.21/auction_biding/index.php/";
    //public static final String BASE_URL = "https://dad58f39.ngrok.io/auction_biding/index.php/";
    private static VolleyApi volleyApi = null;
    private ProgressDialog mProgressDialog;
    private ResponseListener mlistener_response;
//    public static final String googleApi = "http://10.0.2.2:8080/food_waste_managment/googleApi.php";

//

    public static VolleyApi getInstance() {

        if (volleyApi != null)
            return volleyApi;
        else
            return new VolleyApi();
    }

    public void login(final Activity activity, final ResponseListener _mlistener_response, final String username, final String password) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Login/get/mobile/" + username + "/password/" + password + "/isActive/1",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void getcard(final Activity activity, final ResponseListener _mlistener_response, final String cardnumber, final String cvv, final String pin, final String expdate) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/getCard/number/" + cardnumber + "/Cvv/" + cvv + "/exp_date/" + expdate + "/pin/" + pin,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }


    //----------------------------------------------- Volly Api-------------------------------------------------------


    //----------------------------------------------- Login Api-------------------------------------------------------

    public void loginCheck(final Activity activity, final ResponseListener _mlistener_response, final String username) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Login/get/mobile/" + username,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void category(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/getCat/",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void registration(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Login/post",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("first_name", Singleton.firstName);
                    params.put("last_name", Singleton.lastname);
                    params.put("mobile", Singleton.mobile);
                    params.put("email", Singleton.email);
                    params.put("photo", Singleton.img);
                    params.put("password", Singleton.password);
                    params.put("otp", "0");
                    params.put("isActive", Singleton.isActive);


                    System.out.println("map data " + params);

//                    params.put("balance","100");
                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void updateprofile(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Login/post",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("first_name", Singleton.firstName);
                    params.put("last_name", Singleton.lastname);
                    params.put("mobile", Singleton.mobile);
                    params.put("email", Singleton.email);
                    params.put("photo", Singleton.img);
                    params.put("password", Singleton.password);
                    params.put("id", Singleton.id);

                    System.out.println("map data " + params);

//                    params.put("balance","100");
                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }


    public void actioncreation(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/post",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("title", "" + Singleton.title);
                    params.put("description", "" + Singleton.description);
                    params.put("min_bids", Singleton.min_bids);
                    params.put("status", Singleton.status);
                    params.put("start_bid_time", Singleton.startDate);
                    params.put("end_bid_time", Singleton.endDate);
                    params.put("cat_id", Singleton.cat_id);
                    params.put("user_id", Singleton.id);


//                    params.put("balance","100");
                    return params;


                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }


    public void balance(final Activity activity, final ResponseListener _mlistener_response, final String balance) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Login/updateBalance",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("mobile", Singleton.mobile);
                    params.put("balance", balance);

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void insertAuctionImg(final Activity activity, final ResponseListener _mlistener_response, final String auc_img) {
        this.mlistener_response = _mlistener_response;
//        mProgressDialog = new ProgressDialog(activity);
//        mProgressDialog.setMessage("Please Wait...");
//        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/updateImage",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
//                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("auction_photo", auc_img);
                    params.put("auction_id", Singleton.auc_id);

                    System.out.println("parmss  insert img :" + params);
                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void getAuctionImg(final Activity activity, final ResponseListener _mlistener_response,final String auc_id) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL + "Auction/getAuctionImg/auction_id/"+auc_id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void gethistory(final Activity activity, final ResponseListener _mlistener_response, final String user_id,final String status) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/getAuction/user_id/" + user_id+"/status/"+status,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void UpcomingBiding(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
//        mProgressDialog = new ProgressDialog(activity);
//        mProgressDialog.setMessage("Please Wait...");
//        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL + "Auction/get/status/2",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
//                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }


    public void insertBiding(final Activity activity, final ResponseListener _mlistener_response, final String user_id,final String auction_id,final String bids){
        this.mlistener_response = _mlistener_response;
//        mProgressDialog = new ProgressDialog(activity);
//        mProgressDialog.setMessage("Please Wait...");
//        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/postBiding",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
//                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("user_id", user_id);
                    params.put("auction_id",auction_id);
                    params.put("bids",bids);

                    System.out.println("parmss :" + params);
                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void getBiding(final Activity activity, final ResponseListener _mlistener_response,final String auc_id) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL + "Auction/getBiding/auction_id/"+auc_id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }
public void getBidingall(final Activity activity, final ResponseListener _mlistener_response,final String user_id) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL + "Auction/getBiding/user_id/"+user_id,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void updateBiding(final Activity activity, final ResponseListener _mlistener_response,final String auc_id) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait...");
        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/updateAuction/",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("id", auc_id);
                    params.put("title",Singleton.title);
                    params.put("description",Singleton.description);
                    params.put("min_bids",Singleton.min_bids);
                    params.put("status",Singleton.status);
                    params.put("start_bid_time",Singleton.historyModel.getStart_bid_time());
                    params.put("end_bid_time",Singleton.historyModel.getEnd_bid_time());
                    params.put("cat_id",Singleton.historyModel.getCategory());
                    params.put("user_id",Singleton.id);

                    System.out.println("ajfhjkahkfjkak :"+params.toString());


                    return params;

                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public void updateStatus(final Activity activity, final ResponseListener _mlistener_response, final String id,final String status) {
        this.mlistener_response = _mlistener_response;
//        mProgressDialog = new ProgressDialog(activity);
//        mProgressDialog.setMessage("Please Wait...");
//        mProgressDialog.show();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL + "Auction/updateAuctionStatus",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("response", response);
//                            mProgressDialog.dismiss();
                            mlistener_response._onNext(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("error", error.toString());
                            mProgressDialog.dismiss();
                            mlistener_response._onResponseError(error);
                            //username.setError(getString(R.string.error_incorrect_username));

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("id", id);
                    params.put("status", status);

                    System.out.println("parmss  insert img :" + params);
                    return params;
                }


            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            VolleySingleton.getInstance(activity).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            mProgressDialog.dismiss();
            e.printStackTrace();
        }

    }

    public interface ResponseListener {

        void _onResponseError(Throwable e);

        void _onNext(String obj);

    }
}
