package view.lecturer.dialog;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFPreviewDialog extends JDialog {

    private JPanel contentPane;
    private javax.swing.JPanel jPanel1;

    private int currentPage = 0;
    private float zoom = 1.0f; // 100%
    private PDDocument document;
    private PDFRenderer renderer;
    private BufferedImage image;

    private JPanel imagePanel;
    private JLabel pageLabel;
    private JButton prevButton, nextButton, zoomInButton, zoomOutButton;

    public PDFPreviewDialog(Component parent, String filePath) {
        super(SwingUtilities.getWindowAncestor(parent));
        setModal(true);
        setTitle("PDF Preview");
        setLayout(new BorderLayout());

        try {
            document = PDDocument.load(new File(filePath));
            renderer = new PDFRenderer(document);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Cannot open PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        setupUI();
        renderPage();

        setSize(900, 700);
        setLocationRelativeTo(parent);

    }

    private void setupUI() {
        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, this);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return (image != null) ? new Dimension(image.getWidth(), image.getHeight()) : new Dimension(100, 100);
            }
        };

        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        // Navigation Panel
        JPanel controlPanel = new JPanel();
        prevButton = new JButton("← Previous");
        nextButton = new JButton("Next →");
        zoomOutButton = new JButton("Zoom -");
        zoomInButton = new JButton("Zoom +");
        pageLabel = new JLabel();

        controlPanel.add(prevButton);
        controlPanel.add(nextButton);
        controlPanel.add(zoomOutButton);
        controlPanel.add(zoomInButton);
        controlPanel.add(pageLabel);

        add(controlPanel, BorderLayout.SOUTH);

        prevButton.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                renderPage();
            }
        });

        nextButton.addActionListener(e -> {
            if (currentPage < document.getNumberOfPages() - 1) {
                currentPage++;
                renderPage();
            }
        });

        zoomInButton.addActionListener(e -> {
            zoom += 0.1f;
            renderPage();
        });

        zoomOutButton.addActionListener(e -> {
            if (zoom > 0.2f) {
                zoom -= 0.1f;
                renderPage();
            }
        });
    }

    private void renderPage() {
        try {
            image = renderer.renderImage(currentPage, zoom * 2.0f); // PDFBox default is 72 DPI, 2.0 ≈ 144 DPI
            imagePanel.repaint();
            imagePanel.revalidate();

            pageLabel.setText(String.format("Page %d of %d", currentPage + 1, document.getNumberOfPages()));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to render page", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        try {
            if (document != null) {
                document.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUIComponents() {
//        initComponents();
    }

//    private void loadPreview() {
//        System.out.println("Opening: " + filePath);
//
//        try {
//            PDDocument document = PDDocument.load(new File(filePath));
//            PDFRenderer pdfRenderer = new PDFRenderer(document);
//
//            // Render the first page as an image
//            BufferedImage image = pdfRenderer.renderImageWithDPI(0, 150); // use 150 DPI for better performance
//
//            // Create a panel to draw the image
//            JPanel pdfPanel = new JPanel() {
//                @Override
//                protected void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    g.drawImage(image, 0, 0, this);
//                }
//
//                @Override
//                public Dimension getPreferredSize() {
//                    return new Dimension(image.getWidth(), image.getHeight());
//                }
//            };
//
//            JScrollPane scrollPane = new JScrollPane(pdfPanel);
//            jPanel1.setLayout(new BorderLayout());
//            jPanel1.add(scrollPane, BorderLayout.CENTER);
//
//            document.close();
//
//            setSize(800, 600); // Set dialog size
//            setVisible(true);  // Show dialog
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error loading PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

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
