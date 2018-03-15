package org.wcci.citiesandstates;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ControllerTest {
	@InjectMocks
	private Controller underTest;
	@Mock
	private StateRepository stateRepo;
	@Mock
	private State state1;
	@Mock
	Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddASingleStateToModel() {
		long arbritaryStateId = 42L;
		when(stateRepo.findOne(arbritaryStateId)).thenReturn(state1);
		underTest.showState(arbritaryStateId, model);
		verify(model).addAttribute("selectedState", state1);

	}

}
