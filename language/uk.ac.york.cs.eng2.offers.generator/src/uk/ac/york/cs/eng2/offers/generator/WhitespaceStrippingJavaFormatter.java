package uk.ac.york.cs.eng2.offers.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.epsilon.egl.formatter.language.JavaFormatter;

/**
 * Performs additional formatting on the generated code. You should not have to modify this class.
 */
public class WhitespaceStrippingJavaFormatter extends JavaFormatter {

	@Override
	public String format(String text) {
		String indented = super.format(text);

		// Strip all trailing whitespace
		String[] indentedLines = Pattern.compile("^", Pattern.MULTILINE).split(indented);
		for (int i = 0; i < indentedLines.length; i++) {
			indentedLines[i] = indentedLines[i].stripTrailing();
		}

		// Remove unnecessary empty lines
		int i = 0;
		List<String> cleanedLines = new ArrayList<>(indentedLines.length); 
		while (i < indentedLines.length) {
			final String line = indentedLines[i];
			if (!line.isEmpty()) {
				cleanedLines.add(line);
			} else if (i + 1 < indentedLines.length) {
				final String nextLine = indentedLines[i+1];
				if (!nextLine.isBlank() && !nextLine.strip().startsWith("}")) {
					cleanedLines.add(line);
				}
			}

			i++;
		}

		return String.join(System.lineSeparator(), cleanedLines);
	}

}