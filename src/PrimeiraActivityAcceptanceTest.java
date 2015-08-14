import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;

import com.example.meusmedicos.R;
import com.example.meusmedicos.views.MainActivity;
import com.example.meusmedicos.views.consulta.ShowConsultas;

public class PrimeiraActivityAcceptanceTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity primeiraActivity;
	private Instrumentation instrumentation;
	private Button consultasButton;

	public PrimeiraActivityAcceptanceTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(true);
		primeiraActivity = getActivity();
		instrumentation = getInstrumentation();
		consultasButton = (Button) primeiraActivity.findViewById(R.id.button2);
	}

	public void testAoClicarNoMenuDeveChamarSegundaActivity() throws Exception {
		ActivityMonitor monitor = instrumentation.addMonitor(
				ShowConsultas.class.getName(), null, false);

		TouchUtils.clickView(this, consultasButton);

		ShowConsultas segundaActivity = (ShowConsultas) monitor
				.waitForActivityWithTimeout(5000);

		//assertNotNull(segundaActivity);
	}
}
