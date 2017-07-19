package bskr365.com.youxibox;

import java.io.IOException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class YouxiBox extends CordovaPlugin{


	public YouxiBox() {

    }

	@Override
    public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException {
        if("openBox".equals(action)) {
            this.openBox(args, callbackContext);
        }
        else if("boxrest".equals(action))
        {
            this.boxrest(args, callbackContext);
        }

        return true;
    }

	public void openBox(JSONArray args, final CallbackContext callbackContext) throws JSONException
	{
		//
		JSONObject boxInfo = args.getJSONObject(0);
		final String boxID = boxInfo.getString("boxID");
		//boxid
		System.out.println("------正在开柜中。。。。------");
		System.out.println("------BOXID获取:"+boxID+"------");
		this.setboxOut(boxID);
	}



	public void setboxOut(String boxID)
	{
		System.out.println(MainActivity.t);
		if(MainActivity.boxOut!=null){
            try {
            	MainActivity.boxOut.write(boxID.getBytes());
            	System.out.println("------正在写入。。。。------");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

	public void boxrest(JSONArray args, final CallbackContext callbackContext) throws JSONException
  {
		System.out.println("------aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa------");		
      if(MainActivity.boxOut!=null){
           try {
                MainActivity.boxOut.write("write*pcrst=180#".getBytes());
                System.out.println("------心跳------");
  			} catch (IOException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
  			}
      }
  }

}
