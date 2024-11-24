package aplikasiresepmasakan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ahurrez
 */
public class MenuUtamaFrame extends javax.swing.JFrame {

    public MenuUtamaFrame() {
        initComponents();
        
    }
   
        //untuk menyimpan data ke file TXT
        private void eksporKeTXT(String path) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();

        // Tulis header
        writer.write("Judul Masakan\tBahan-Bahan\tTahap Pengerjaan\tAlat");
        writer.newLine();

        // Tulis data baris demi baris
        for (int i = 0; i < model.getRowCount(); i++) {
            writer.write(
                model.getValueAt(i, 0) + "\t" +
                model.getValueAt(i, 1) + "\t" +
                model.getValueAt(i, 2) + "\t" +
                model.getValueAt(i, 3)
            );
            writer.newLine();
        }

            JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke TXT!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file TXT.", "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}
        
        //untuk menyimpan data ke file JSON
        private void eksporKeJSON(String path) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
                JSONArray jsonArray = new JSONArray();

        // Tambah data ke JSON
        for (int i = 0; i < model.getRowCount(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Judul", model.getValueAt(i, 0));
            jsonObject.put("Bahan", model.getValueAt(i, 1));
            jsonObject.put("Tahap", model.getValueAt(i, 2));
            jsonObject.put("Alat", model.getValueAt(i, 3));
            jsonArray.put(jsonObject);
        }

            // Tulis JSON ke file
            writer.write(jsonArray.toString(4)); // Indentasi 4 untuk keindahan
            JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke JSON!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file JSON.", "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}

        //untuk Memasukkan data dari file TXT
        private void imporDariTXT(String path) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
            String line;
            reader.readLine(); // Lewati header
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");
            model.addRow(data);
        }
            JOptionPane.showMessageDialog(this, "Data berhasil diimpor dari TXT!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membaca file TXT.", "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}
        
        //untuk Memasukkan data dari file TXT
        private void imporDariJSON(String path) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
                StringBuilder jsonString = new StringBuilder();
                String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
        }

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                model.addRow(new Object[]{
                    jsonObject.getString("Judul"),
                    jsonObject.getString("Bahan"),
                    jsonObject.getString("Tahap"),
                    jsonObject.getString("Alat")
            });
        }

        JOptionPane.showMessageDialog(this, "Data berhasil diimpor dari JSON!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException | JSONException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membaca file JSON.", "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TJudul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABahan = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAPengerjaan = new javax.swing.JTextArea();
        BSimpan = new javax.swing.JButton();
        BRestart = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        CBAlatMasak = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBDataResep = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        BModif = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        BCari = new javax.swing.JButton();
        BEkspor = new javax.swing.JButton();
        BCetak = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        BKeluar = new javax.swing.JButton();
        BImpor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 50, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 240, 255));
        jLabel2.setText("\"Menu Mengisi Resep Masakan\"");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 240, 255));
        jLabel5.setText("Silahkan Isi Data-data yang di Minta :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 240, 255));
        jLabel6.setText("Judul Masakan :");

        TJudul.setBackground(new java.awt.Color(50, 70, 100));
        TJudul.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TJudul.setForeground(new java.awt.Color(255, 255, 255));
        TJudul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(220, 240, 255));
        jLabel7.setText("Bahan-bahan :");

        TABahan.setBackground(new java.awt.Color(50, 70, 100));
        TABahan.setColumns(20);
        TABahan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TABahan.setForeground(new java.awt.Color(255, 255, 255));
        TABahan.setRows(5);
        TABahan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jScrollPane1.setViewportView(TABahan);

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(220, 240, 255));
        jLabel8.setText("Tahap Pengerjaan :");

        TAPengerjaan.setBackground(new java.awt.Color(50, 70, 100));
        TAPengerjaan.setColumns(20);
        TAPengerjaan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TAPengerjaan.setForeground(new java.awt.Color(255, 255, 255));
        TAPengerjaan.setRows(5);
        TAPengerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jScrollPane2.setViewportView(TAPengerjaan);

        BSimpan.setBackground(new java.awt.Color(0, 128, 0));
        BSimpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BSimpan.setText("Simpan");
        BSimpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BRestart.setBackground(new java.awt.Color(50, 70, 100));
        BRestart.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BRestart.setForeground(new java.awt.Color(255, 255, 255));
        BRestart.setText("Restart");
        BRestart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRestartActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(220, 240, 255));
        jLabel9.setText("Alat Utama yang Digunakan :");

        CBAlatMasak.setBackground(new java.awt.Color(50, 70, 100));
        CBAlatMasak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CBAlatMasak.setForeground(new java.awt.Color(255, 255, 255));
        CBAlatMasak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wajan", "Panci", "Teflon", "Blender", "Kukus-san" }));
        CBAlatMasak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        TBDataResep.setBackground(new java.awt.Color(153, 153, 255));
        TBDataResep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        TBDataResep.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TBDataResep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul Masakan", "Bahan-Bahan", "Tahap Pengerjaan", "Alat Utama"
            }
        ));
        jScrollPane3.setViewportView(TBDataResep);

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(220, 240, 255));
        jLabel10.setText("Data Resep Masakan yang Tersimpan :");

        BModif.setBackground(new java.awt.Color(50, 70, 100));
        BModif.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BModif.setForeground(new java.awt.Color(255, 255, 255));
        BModif.setText("Modif");
        BModif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModifActionPerformed(evt);
            }
        });

        BHapus.setBackground(new java.awt.Color(50, 70, 100));
        BHapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BHapus.setForeground(new java.awt.Color(255, 255, 255));
        BHapus.setText("Hapus");
        BHapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        BCari.setBackground(new java.awt.Color(50, 70, 100));
        BCari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BCari.setForeground(new java.awt.Color(255, 255, 255));
        BCari.setText("Cari");
        BCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
            }
        });

        BEkspor.setBackground(new java.awt.Color(50, 70, 100));
        BEkspor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BEkspor.setForeground(new java.awt.Color(255, 255, 255));
        BEkspor.setText("Ekspor");
        BEkspor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BEkspor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEksporActionPerformed(evt);
            }
        });

        BCetak.setBackground(new java.awt.Color(50, 70, 100));
        BCetak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BCetak.setForeground(new java.awt.Color(255, 255, 255));
        BCetak.setText("Cetak");
        BCetak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCetakActionPerformed(evt);
            }
        });

        BKeluar.setBackground(new java.awt.Color(255, 140, 0));
        BKeluar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BKeluar.setForeground(new java.awt.Color(255, 255, 255));
        BKeluar.setText("Keluar");
        BKeluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BKeluarActionPerformed(evt);
            }
        });

        BImpor.setBackground(new java.awt.Color(50, 70, 100));
        BImpor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BImpor.setForeground(new java.awt.Color(255, 255, 255));
        BImpor.setText("Impor");
        BImpor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BImpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BImporActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(101, 101, 101)
                .addComponent(TJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(114, 114, 114)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(80, 80, 80)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(CBAlatMasak, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(735, 735, 735)
                .addComponent(BKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(BModif, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BCari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BEkspor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BImpor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(TJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(CBAlatMasak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BSimpan)
                            .addComponent(BRestart)
                            .addComponent(BCetak))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BModif)
                    .addComponent(BHapus)
                    .addComponent(BCari)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BEkspor)
                        .addComponent(BImpor)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BKeluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        // Ambil data dari komponen input
        String judul = TJudul.getText();
        String bahan = TABahan.getText();
        String tahap = TAPengerjaan.getText();
        String alat = CBAlatMasak.getSelectedItem().toString();

        // Validasi input (opsional, bisa ditambahkan jika dibutuhkan)
        if (judul.isEmpty() || bahan.isEmpty() || tahap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Tambahkan data ke tabel
        DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
        model.addRow(new Object[]{judul, bahan, tahap, alat});
        
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRestartActionPerformed
        // Reset semua input
        TJudul.setText("");
        TABahan.setText("");
        TAPengerjaan.setText("");
        CBAlatMasak.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Input berhasil di-reset!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BRestartActionPerformed

    private void BCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCetakActionPerformed
        // Ambil data dari input
        String judul = TJudul.getText();
        String bahan = TABahan.getText();
        String tahap = TAPengerjaan.getText();
        String alat = CBAlatMasak.getSelectedItem().toString();

        // Validasi input
        if (judul.isEmpty() || bahan.isEmpty() || tahap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi untuk mencetak!", "Peringatan", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Buat konten file dalam format paragraf
        String konten = "Resep Masakan: " + judul + "\n\n" +
                        "Bahan-Bahan:\n" + bahan + "\n\n" +
                        "Tahap Pengerjaan:\n" + tahap + "\n\n" +
                        "Alat yang Digunakan: " + alat + "\n";

        // Pilih lokasi file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan File Resep");
        int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                        writer.write(konten);
                        JOptionPane.showMessageDialog(this, "Resep berhasil dicetak ke file!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file.", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_BCetakActionPerformed

    private void BModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModifActionPerformed
        // Ambil baris yang dipilih di tabel
        int selectedRow = TBDataResep.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dimodifikasi!", "Informasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Ambil data baru dari input
        String judul = TJudul.getText();
        String bahan = TABahan.getText();
        String tahap = TAPengerjaan.getText();
        String alat = CBAlatMasak.getSelectedItem().toString();

        // Validasi input
        if (judul.isEmpty() || bahan.isEmpty() || tahap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi untuk memodifikasi!", "Informasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Update data di tabel
        DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
        model.setValueAt(judul, selectedRow, 0);
        model.setValueAt(bahan, selectedRow, 1);
        model.setValueAt(tahap, selectedRow, 2);
        model.setValueAt(alat, selectedRow, 3);

            JOptionPane.showMessageDialog(this, "Data berhasil dimodifikasi!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BModifActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // Ambil baris yang dipilih di tabel
        int selectedRow = TBDataResep.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Informasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
                model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BHapusActionPerformed

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        // Implementasi pencarian sederhana berdasarkan Judul
        String keyword = JOptionPane.showInputDialog(this, "Masukkan judul masakan yang dicari:");
            if (keyword != null && !keyword.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) TBDataResep.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                TBDataResep.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
            } else {
                JOptionPane.showMessageDialog(this, "Kata kunci pencarian tidak boleh kosong!", "Informasi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BCariActionPerformed

    private void BEksporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEksporActionPerformed
        // Pilih format ekspor
        String[] options = {"TXT", "JSON"};
        String pilihan = (String) JOptionPane.showInputDialog(
            this, 
                "Pilih format ekspor:", 
                "Ekspor Data", 
                    JOptionPane.QUESTION_MESSAGE, 
            null, 
                options, 
                options[0]
        );

        if (pilihan == null) return; // User membatalkan dialog

        // Pilih lokasi file untuk menyimpan
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan File Ekspor");
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();

        // Tambahkan ekstensi file sesuai format
        switch (pilihan) {
            case "TXT":
                path += ".txt";
                eksporKeTXT(path);
                break;
            case "JSON":
                path += ".json";
                eksporKeJSON(path);
                break;
        }
    }
    }//GEN-LAST:event_BEksporActionPerformed

    private void BImporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BImporActionPerformed
        // Pilih file untuk diimpor
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File untuk Impor");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            String path = fileToOpen.getAbsolutePath();

            // Tentukan format file berdasarkan ekstensi
            if (path.endsWith(".txt")) {
                imporDariTXT(path);
            } else if (path.endsWith(".json")) {
                imporDariJSON(path);
            } else {
                JOptionPane.showMessageDialog(this, "Format file tidak didukung!", "Pemberitahuan", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_BImporActionPerformed

    private void BKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BKeluarActionPerformed
        // Menampilkan dialog konfirmasi ketika pengguna ingin keluar
        int pilihan = JOptionPane.showConfirmDialog(
            this, 
                "Apakah Anda yakin ingin keluar dari Menu Aplikasi Resep Masakan?", 
                "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
            );
    
        // Mengecek pilihan pengguna
        if (pilihan == JOptionPane.YES_OPTION) {
            // Jika pilihannya 'Yes', keluar dari aplikasi
            System.exit(0);  // Menghentikan aplikasi
        }
            // Jika pilihannya 'No', tidak melakukan apa-apa (dialog tertutup)
    }//GEN-LAST:event_BKeluarActionPerformed

        private void TBDataResepMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // Dapatkan baris yang diklik
        int selectedRow = TBDataResep.getSelectedRow();
    
        // Periksa apakah ada baris yang dipilih
        if (selectedRow != -1) {
            // Ambil data dari tabel berdasarkan baris yang dipilih
            String judul = (String) TBDataResep.getValueAt(selectedRow, 0); // Kolom Judul
            String bahan = (String) TBDataResep.getValueAt(selectedRow, 1); // Kolom Bahan-Bahan
            String tahap = (String) TBDataResep.getValueAt(selectedRow, 2); // Kolom Tahap Pengerjaan
            String alat = (String) TBDataResep.getValueAt(selectedRow, 3);  // Kolom Alat Masak

            // Masukkan data ke komponen input
            TJudul.setText(judul);
            TABahan.setText(bahan);
            TAPengerjaan.setText(tahap);
            CBAlatMasak.setSelectedItem(alat); // Pilihan di ComboBox
        } else {
            // Jika tidak ada baris yang dipilih, tampilkan peringatan (opsional)
            JOptionPane.showMessageDialog(this, "Pilih baris yang valid!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_TBDataResepMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtamaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtamaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCari;
    private javax.swing.JButton BCetak;
    private javax.swing.JButton BEkspor;
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BImpor;
    private javax.swing.JButton BKeluar;
    private javax.swing.JButton BModif;
    private javax.swing.JButton BRestart;
    private javax.swing.JButton BSimpan;
    private javax.swing.JComboBox<String> CBAlatMasak;
    private javax.swing.JTextArea TABahan;
    private javax.swing.JTextArea TAPengerjaan;
    private javax.swing.JTable TBDataResep;
    private javax.swing.JTextField TJudul;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
