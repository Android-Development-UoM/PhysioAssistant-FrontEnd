package uom.android.physioassistant.activities.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import uom.android.physioassistant.R;
import uom.android.physioassistant.models.PhysioAction;
import uom.android.physioassistant.ui.FragmentType;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PhysioAction> physioActions;

    private HomeFragment homeFragment;
    public ServiceAdapter(HomeFragment homeFragment){
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item,parent,false);
        return new ServiceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String imageURL = "https://img.freepik.com/premium-photo/spa-arrangement-with-towel-soap-salt_23-2148268482.jpg?w=2000";
        Glide.with(homeFragment.getContext()).asBitmap().load(imageURL).into(holder.serviceImage);

        holder.serviceName.setText(physioActions.get(position).getName());
        holder.serviceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatientActivity patientActivity = (PatientActivity) homeFragment.getContext();
                patientActivity.getNavBar().setVisibility(View.GONE);
                patientActivity.replaceFragment(FragmentType.SERVICE_FRAGMENT.getFragment(), R.anim.fade_in,R.anim.fade_out,
                        homeFragment.serviceBundle(physioActions.get(position).getCode()));
            }
        });

    }

    public void setPhysioActions(ArrayList<PhysioAction> physioActions) {
        this.physioActions = physioActions;
    }

    @Override
    public int getItemCount() {
        return physioActions.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{


        ImageView serviceImage;
        TextView serviceName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            serviceImage = itemView.findViewById(R.id.serviceImage);
            serviceName = itemView.findViewById(R.id.serviceName);

        }
    }

}
