package oleg.hubal.com.tm_homework11;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 20.03.2016.
 */
public class DragFragment extends Fragment implements View.OnClickListener, View.OnTouchListener{

    private View view;
    private Button btnImage, btnText, btnButton;
    private FrameLayout dragField;
    private float x, y;
    private boolean isPressed = false;
    private int fieldX, fieldY;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_drag, container, false);
        initViews();

        return view;
    }

    @Override
    public void onClick(View v) {
        dragField.removeAllViews();
        switch (v.getId()) {
            case R.id.btn_choose_btn:
                addButton();
                break;
            case R.id.btn_choose_image:
                addImage();
                break;
            case R.id.btn_choose_text:
                addTextView();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int[] i = new int[2];
        dragField.getLocationInWindow(i);
        fieldX = i[0];
        fieldY = i[1];
        switch(event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                x = event.getRawX();
                y = event.getRawY();
                v.setX(x - fieldX - v.getWidth() / 2);
                v.setY(y - fieldY - v.getHeight() / 2);
                break;
        }
        return true;
    }



    private void addTextView() {
        TextView textToDrag = new TextView(getContext());
        textToDrag.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        textToDrag.setText(R.string.drag_text_view);
        dragField.addView(textToDrag);
        textToDrag.setOnTouchListener(this);
    }

    private void addImage() {
        ImageView imageToDrag = new ImageView(getContext());
        imageToDrag.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        imageToDrag.setImageResource(R.mipmap.ic_launcher);
        dragField.addView(imageToDrag);
        imageToDrag.setOnTouchListener(this);

    }

    private void addButton() {
        Button btnToDrag = new Button(getContext());
        btnToDrag.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        btnToDrag.setText(R.string.drag_btn_text);
        dragField.addView(btnToDrag);
        btnToDrag.setOnTouchListener(this);
    }

    private void initViews() {
        btnImage = (Button) view.findViewById(R.id.btn_choose_image);
        btnButton = (Button) view.findViewById(R.id.btn_choose_btn);
        btnText = (Button) view.findViewById(R.id.btn_choose_text);

        btnImage.setOnClickListener(this);
        btnButton.setOnClickListener(this);
        btnText.setOnClickListener(this);

        dragField = (FrameLayout) view.findViewById(R.id.field_to_drag);
    }
}
