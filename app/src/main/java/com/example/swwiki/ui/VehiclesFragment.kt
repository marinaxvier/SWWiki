import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.VehiclesData
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.*
import kotlinx.android.synthetic.main.fragment_starships_and_vehicles.*

class VehiclesFragment(val id: String) : Fragment(R.layout.fragment_starships_and_vehicles) {

    private lateinit var viewModel: VehiclesFragmentViewModel
    private var vehiclesDataResult: VehiclesData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = VehiclesFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VehiclesFragmentViewModel::class.java)
        viewModel.getVehiclesDetail(id)
        viewModel.vehiclesDataResponse.observe(this, Observer { vehiclesDataResponse ->
            if (vehiclesDataResponse.isSuccessful){
                vehiclesDataResult = vehiclesDataResponse.body()
            }
            detailConfig(vehiclesDataResult!!)
        })
    }

    fun detailConfig(vehiclesData: VehiclesData){
        tvModel.text = vehiclesData.model
        tvLength.text = vehiclesData.length
        tvPassengers.text = vehiclesData.passengers
        tvMaxAtmospheringSpeed.text = vehiclesData.maxAtmospheringSpeed
        tvCargoCapacity.text = vehiclesData.cargoCapacity
    }
}