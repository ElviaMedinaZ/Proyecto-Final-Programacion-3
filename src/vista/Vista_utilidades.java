package vista;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;


public class Vista_utilidades {
	
	
	public Vista_utilidades () {
		
	}
	
	 public void applyLettersOnlyFilter(JTextField textField) {
	        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
	            private final Pattern pattern = Pattern.compile("[a-zA-Z]*");

	            @Override
	            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
	                if (text == null) return;

	                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	                if (pattern.matcher(newValue).matches()) {
	                    super.insertString(fb, offset, text, attr);
	                }
	            }

	            @Override
	            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	                if (text == null) return;

	                String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	                if (pattern.matcher(newValue).matches()) {
	                    super.replace(fb, offset, length, text, attrs);
	                }
	            }
	        });
	    }
	 
	    public static void limitTextFieldLength(JTextField textField, int maxLength) {
	        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
	            @Override
	            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
	                int futureLength = currentText.length() + text.length() - length;
	                if (futureLength <= maxLength) {
	                    super.replace(fb, offset, length, text, attrs);
	                }
	            }
	        });
	    }

}
