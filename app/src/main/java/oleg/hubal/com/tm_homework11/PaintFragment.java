package oleg.hubal.com.tm_homework11;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by User on 20.03.2016.
 */
public class PaintFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnColor1, btnColor2, btnColor3;
    private FrameLayout paintField;
    private DrawingView drawingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_paint, container, false);
        initViews();
        paintField.addView(drawingView);
        return view;
    }

    private void initViews() {
        drawingView = new DrawingView(getContext());

        btnColor1 = (Button) view.findViewById(R.id.btn_choose_color1);
        btnColor2 = (Button) view.findViewById(R.id.btn_choose_color2);
        btnColor3 = (Button) view.findViewById(R.id.btn_choose_color3);

        btnColor1.setOnClickListener(this);
        btnColor2.setOnClickListener(this);
        btnColor3.setOnClickListener(this);

        paintField = (FrameLayout) view.findViewById(R.id.field_to_paint);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_choose_color1:
                drawingView.setColor(getResources().getColor(R.color.paint_color1));
                break;
            case R.id.btn_choose_color2:
                drawingView.setColor(getResources().getColor(R.color.paint_color2));
                break;
            case R.id.btn_choose_color3:
                drawingView.setColor(getResources().getColor(R.color.paint_color3));
                break;
        }
    }
}
