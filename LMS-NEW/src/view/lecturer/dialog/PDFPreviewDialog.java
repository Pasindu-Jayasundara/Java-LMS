package view.lecturer.dialog;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PDFPreviewDialog extends JDialog {

    private JPanel contentPane;
    private javax.swing.JPanel jPanel1;

    private final String filePath;

    public PDFPreviewDialog(Dialog dialog, String filePath) {
        setModal(true);
        setLocationRelativeTo(dialog);

        this.filePath = filePath;
    }

    public PDFPreviewDialog(JPanel panel, String filePath) {
        setModal(true);
        setLocationRelativeTo(panel);

        this.filePath = filePath;
    }

    private void createUIComponents() {
        initComponents();

        loadPreview();
    }

    private void loadPreview() {

        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            JPanel pdfPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        pdfRenderer.renderImageWithDPI(0, 300); // Render the first page
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            add(new JScrollPane(pdfPanel), BorderLayout.CENTER);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 917, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 585, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

}
