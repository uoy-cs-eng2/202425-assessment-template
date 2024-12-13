package uk.ac.york.cs.eng2.offers.generator;

import java.io.File;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.EmfModel;

import uk.ac.york.cs.eng2.offers.OffersPackage;

/**
 * Code generator using EGX. You should not have to modify this class.
 */
public class OffersGenerator {

	private File targetFolder = new File(".");
	private URI inputModelURI;

	public Object run() throws URISyntaxException, Exception {
		EgxModule module = new EgxModule();

		// Set target folder *before* we parse, so the template factory is given the right root location
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		templateFactory.setOutputRoot(targetFolder.getCanonicalPath());
		templateFactory.setDefaultFormatter(new WhitespaceStrippingJavaFormatter());
		module.setTemplateFactory(templateFactory);
		
		// Parse the EGX and EGL scripts
		boolean success = module.parse(OffersGenerator.class.getResource("scripts/main.egx").toURI());
		if (!success) {
			throw new RuntimeException("There were parsing problems in the script: " + module.getParseProblems());
		}

		// Load the input model
		EmfModel model = new EmfModel();
		model.setName("Model");
		model.setReadOnLoad(true);
		model.setStoredOnDisposal(false);
		model.setMetamodelUri(OffersPackage.eNS_URI);
		model.setModelFileUri(inputModelURI);
		model.load();
		module.getContext().getModelRepository().addModel(model);

		// Execute the module and dispose of it
		try {
			return module.execute();
		} finally {
			module.getContext().getModelRepository().dispose();
			module.getContext().dispose();
		}
	}

	public URI getInputModelURI() {
		return inputModelURI;
	}

	public void setInputModelURI(URI inputModelURI) {
		this.inputModelURI = inputModelURI;
	}

	public File getTargetFolder() {
		return targetFolder;
	}

	public void setTargetFolder(File targetFolder) {
		this.targetFolder = targetFolder;
	}

}
