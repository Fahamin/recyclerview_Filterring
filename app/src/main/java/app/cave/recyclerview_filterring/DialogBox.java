package app.cave.recyclerview_filterring;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogBox {

    Activity activity;

    public void showDialog(Context context, String namep, String postion)
    {
        Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);

        TextView name,pos;

        name = dialog.findViewById(R.id.namTxt);
        pos = dialog.findViewById(R.id.poTxt);

        name.setText(namep);
        pos.setText(postion);
        dialog.show();

        
    }
}
