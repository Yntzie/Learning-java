/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelView;

import controller.PembelianKendaraanControl;
import controller.CustomerControl;
import controller.KendaraanControl;
import controller.LayananControl;
import exception.InputKosongException;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.awt.Component;

import model.PembelianKendaraan;
import model.Customer;
import model.Kendaraan;
import model.LayananServis;

import table.TablePembelianKendaraan;

public class TransaksiMainPanel extends javax.swing.JPanel {
    private PembelianKendaraanControl pembelianControl;
    private CustomerControl customerControl;
    private KendaraanControl kendaraanControl;
    private LayananControl layananControl;

    private PembelianKendaraan pk = null;
    String action = null;
    int selectedId = 0;
    
    List<Customer> listCustomer;
    List<Kendaraan> listKendaraan;
    List<LayananServis> listLayanan;
    
    private Component rootPane;
    
    public void setKendaraanToDropdown()
    {
        listKendaraan = kendaraanControl.showListKendaraan();
        System.out.println(listKendaraan.size());
        for(int i = 0; i< listKendaraan.size(); i++)
        {
            namaKendaraanDropdown.addItem(listKendaraan.get(i));
        }
    }
    
    public void setCustomerToDropdown()
    {
        listCustomer = customerControl.showListCustomer();
        for(int i = 0; i< listCustomer.size(); i++)
        {
            namaCustomerDropdown.addItem(listCustomer.get(i));
        }
    }
    
    public void setLayananToDropdown()
    {
        listLayanan = layananControl.showListLayanan();
        for(int i = 0; i< listLayanan.size(); i++)
        {
            namaLayananDropdown.addItem(listLayanan.get(i));
        }
    }

    public void setRadioButtonValue()        
    {
        bcaRadio.setActionCommand("BCA");
        briRadio.setActionCommand("BRI");
        mayRadio.setActionCommand("May Bank");
        bpdRadio.setActionCommand("BPD DIY");
        tunaiRadio.setActionCommand("Tunai");
    }
    
    private void refreshReport() {
        reportTextField.setText("Rp " +String.valueOf(pembelianControl.getTotalPendapatan()));
        
    }
    
    public void showTableBySearch(String target)
    {
        tablePembelian.setModel(pembelianControl.showTable(target));
    }
    
    public void inputKosongPembelianException() throws InputKosongException
    {
        if(namaCustomerDropdown.getSelectedIndex() == -1 || namaKendaraanDropdown.getSelectedIndex() == -1
                || jumlahPembelianInput.getText().isEmpty()
                || (!ManualCheckbox.isSelected() && !OtomatisCheckbox.isSelected())
                || metodePembayaranGroup.getSelection().getActionCommand() == null)
        {
            throw new InputKosongException();
        }
    }
    
    
    public void clearText()
    {
        namaCustomerDropdown.setSelectedIndex(-1);
        namaKendaraanDropdown.setSelectedIndex(-1);
        namaLayananDropdown.setSelectedIndex(-1);
        
        ManualCheckbox.setSelected(false);
        OtomatisCheckbox.setSelected(false);
        
        metodePembayaranGroup.clearSelection();
        
        searchTransaksiInputTextField.setText("");
        jumlahPembelianInput.setText("");
    }
    
    public void setEditDeleteBtn(boolean value){
        barukanTransaksiButton.setEnabled(value);
        hapusTransaksiButton.setEnabled(value);
    }

    public void setComponent(boolean value){
        namaCustomerDropdown.setEnabled(value);
        namaKendaraanDropdown.setEnabled(value);
        namaLayananDropdown.setEnabled(value);
        jumlahPembelianInput.setEnabled(value);

        ManualCheckbox.setEnabled(value);
        OtomatisCheckbox.setEnabled(value);

        simpanTransaksiButton.setEnabled(value);
        batalTransaksiButton.setEnabled(value);
    }

    public void setRadioComponent(boolean value){
        bcaRadio.setEnabled(value);
        briRadio.setEnabled(value);
        mayRadio.setEnabled(value);
        bpdRadio.setEnabled(value);
        tunaiRadio.setEnabled(value);
    }

    public TransaksiMainPanel() {
        initComponents();
        setOpaque(false);

        pembelianControl = new PembelianKendaraanControl();
        customerControl = new CustomerControl();
        kendaraanControl = new KendaraanControl();
        layananControl = new LayananControl();

        setCustomerToDropdown();
        setKendaraanToDropdown();
        setLayananToDropdown();
        setRadioButtonValue();

        showTableBySearch("");
        
        //report
        
        reportTextField.setEnabled(false);
        refreshReport();
        // RESET
        clearText();
        setComponent(false);
        setRadioComponent(false);
        setEditDeleteBtn(false);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        metodePembayaranGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        searchTransaksiInputPanel = new javax.swing.JPanel();
        searchTransaksiInputLabel = new javax.swing.JLabel();
        searchTransaksiInputTextField = new javax.swing.JTextField();
        searchTransaksiInputButton = new javax.swing.JButton();
        transaksiFormPanel = new javax.swing.JPanel();
        transaksiButtonPanel = new javax.swing.JPanel();
        barukanTransaksiButton = new javax.swing.JButton();
        hapusTransaksiButton = new javax.swing.JButton();
        tambahTransaksiButton = new javax.swing.JButton();
        namaCustomerPanel = new javax.swing.JPanel();
        namaCustomerLabel = new javax.swing.JLabel();
        namaCustomerDropdown = new javax.swing.JComboBox<>();
        namaKendaraanPanel = new javax.swing.JPanel();
        namaKendaraanLabel = new javax.swing.JLabel();
        namaKendaraanDropdown = new javax.swing.JComboBox<>();
        namaLayananPanel = new javax.swing.JPanel();
        namaLayananDropdown = new javax.swing.JComboBox<>();
        namaLayananLabel = new javax.swing.JLabel();
        jumlahPembelianPanel = new javax.swing.JPanel();
        jumlahLabel = new javax.swing.JLabel();
        jumlahPembelianInput = new java.awt.TextField();
        checkboxPanel = new javax.swing.JPanel();
        atributLabel = new javax.swing.JLabel();
        ManualCheckbox = new javax.swing.JCheckBox();
        OtomatisCheckbox = new javax.swing.JCheckBox();
        metodePembayaranPanel = new javax.swing.JPanel();
        metodePembayaranLabel = new javax.swing.JLabel();
        bcaRadio = new javax.swing.JRadioButton();
        briRadio = new javax.swing.JRadioButton();
        mayRadio = new javax.swing.JRadioButton();
        bpdRadio = new javax.swing.JRadioButton();
        tunaiRadio = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        simpanTransaksiButton = new javax.swing.JButton();
        batalTransaksiButton = new javax.swing.JButton();
        reportPanel = new javax.swing.JPanel();
        reportLabel = new javax.swing.JLabel();
        reportTextField = new javax.swing.JTextField();

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(1318, 757));

        searchTransaksiInputPanel.setBackground(new java.awt.Color(255, 255, 255));

        searchTransaksiInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputLabel.setText("Pencarian Transaksi");

        searchTransaksiInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTransaksiInputTextFieldKeyPressed(evt);
            }
        });

        searchTransaksiInputButton.setBackground(new java.awt.Color(27, 26, 85));
        searchTransaksiInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputButton.setForeground(new java.awt.Color(255, 255, 255));
        searchTransaksiInputButton.setText("Cari");
        searchTransaksiInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransaksiInputButtonActionPerformed(evt);
            }
        });

        transaksiFormPanel.setBackground(new java.awt.Color(255, 255, 255));

        transaksiButtonPanel.setBackground(new java.awt.Color(255, 255, 255));

        barukanTransaksiButton.setBackground(new java.awt.Color(255, 189, 3));
        barukanTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        barukanTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        barukanTransaksiButton.setText("Barukan");
        barukanTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanTransaksiButtonActionPerformed(evt);
            }
        });

        hapusTransaksiButton.setBackground(new java.awt.Color(237, 8, 0));
        hapusTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hapusTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusTransaksiButton.setText("Hapus");
        hapusTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusTransaksiButtonActionPerformed(evt);
            }
        });

        tambahTransaksiButton.setBackground(new java.awt.Color(51, 178, 73));
        tambahTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tambahTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahTransaksiButton.setText("Tambah");
        tambahTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahTransaksiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transaksiButtonPanelLayout = new javax.swing.GroupLayout(transaksiButtonPanel);
        transaksiButtonPanel.setLayout(transaksiButtonPanelLayout);
        transaksiButtonPanelLayout.setHorizontalGroup(
            transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahTransaksiButton)
                .addGap(18, 18, 18)
                .addComponent(barukanTransaksiButton)
                .addGap(18, 18, 18)
                .addComponent(hapusTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        transaksiButtonPanelLayout.setVerticalGroup(
            transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barukanTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahTransaksiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusTransaksiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaCustomerPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaCustomerPanel.setPreferredSize(new java.awt.Dimension(322, 60));

        namaCustomerLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaCustomerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaCustomerLabel.setText("Nama Customer");

        namaCustomerDropdown.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaCustomerDropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namaCustomerDropdownMouseClicked(evt);
            }
        });
        namaCustomerDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaCustomerDropdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namaCustomerPanelLayout = new javax.swing.GroupLayout(namaCustomerPanel);
        namaCustomerPanel.setLayout(namaCustomerPanelLayout);
        namaCustomerPanelLayout.setHorizontalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaCustomerDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaCustomerPanelLayout.setVerticalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaCustomerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaCustomerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        namaKendaraanPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaKendaraanPanel.setPreferredSize(new java.awt.Dimension(322, 60));

        namaKendaraanLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaKendaraanLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaKendaraanLabel.setText("Nama Kendaraan");

        namaKendaraanDropdown.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaKendaraanDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKendaraanDropdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namaKendaraanPanelLayout = new javax.swing.GroupLayout(namaKendaraanPanel);
        namaKendaraanPanel.setLayout(namaKendaraanPanelLayout);
        namaKendaraanPanelLayout.setHorizontalGroup(
            namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKendaraanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(namaKendaraanDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaKendaraanPanelLayout.setVerticalGroup(
            namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaKendaraanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        namaLayananPanel.setBackground(new java.awt.Color(255, 255, 255));

        namaLayananDropdown.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaLayananDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaLayananDropdownActionPerformed(evt);
            }
        });

        namaLayananLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaLayananLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaLayananLabel.setText("Nama Layanan");

        javax.swing.GroupLayout namaLayananPanelLayout = new javax.swing.GroupLayout(namaLayananPanel);
        namaLayananPanel.setLayout(namaLayananPanelLayout);
        namaLayananPanelLayout.setHorizontalGroup(
            namaLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaLayananPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaLayananDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaLayananLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaLayananPanelLayout.setVerticalGroup(
            namaLayananPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, namaLayananPanelLayout.createSequentialGroup()
                .addComponent(namaLayananLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaLayananDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jumlahPembelianPanel.setBackground(new java.awt.Color(255, 255, 255));
        jumlahPembelianPanel.setPreferredSize(new java.awt.Dimension(322, 60));

        jumlahLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jumlahLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahLabel.setText("Jumlah Pembelian");

        jumlahPembelianInput.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jumlahPembelianInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPembelianInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jumlahPembelianPanelLayout = new javax.swing.GroupLayout(jumlahPembelianPanel);
        jumlahPembelianPanel.setLayout(jumlahPembelianPanelLayout);
        jumlahPembelianPanelLayout.setHorizontalGroup(
            jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jumlahPembelianPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(jumlahPembelianInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jumlahPembelianPanelLayout.setVerticalGroup(
            jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahPembelianPanelLayout.createSequentialGroup()
                .addComponent(jumlahLabel)
                .addGap(2, 2, 2)
                .addComponent(jumlahPembelianInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        checkboxPanel.setBackground(new java.awt.Color(255, 255, 255));
        checkboxPanel.setPreferredSize(new java.awt.Dimension(180, 190));

        atributLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        atributLabel.setText("Transmisi Kendaraan");

        ManualCheckbox.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        ManualCheckbox.setText("Manual");
        ManualCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualCheckboxActionPerformed(evt);
            }
        });

        OtomatisCheckbox.setBackground(new java.awt.Color(255, 255, 255));
        OtomatisCheckbox.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        OtomatisCheckbox.setText("Otomatis");

        javax.swing.GroupLayout checkboxPanelLayout = new javax.swing.GroupLayout(checkboxPanel);
        checkboxPanel.setLayout(checkboxPanelLayout);
        checkboxPanelLayout.setHorizontalGroup(
            checkboxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkboxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkboxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atributLabel)
                    .addComponent(ManualCheckbox)
                    .addComponent(OtomatisCheckbox))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        checkboxPanelLayout.setVerticalGroup(
            checkboxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkboxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atributLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManualCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OtomatisCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        metodePembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));

        metodePembayaranLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        metodePembayaranLabel.setText("Metode Pembayaran");

        metodePembayaranGroup.add(bcaRadio);
        bcaRadio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        bcaRadio.setText("BCA");

        metodePembayaranGroup.add(briRadio);
        briRadio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        briRadio.setText("BRI");
        briRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briRadioActionPerformed(evt);
            }
        });

        metodePembayaranGroup.add(mayRadio);
        mayRadio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        mayRadio.setText("May Bank");

        metodePembayaranGroup.add(bpdRadio);
        bpdRadio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        bpdRadio.setText("BPD DIY");

        metodePembayaranGroup.add(tunaiRadio);
        tunaiRadio.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tunaiRadio.setText("Tunai");

        javax.swing.GroupLayout metodePembayaranPanelLayout = new javax.swing.GroupLayout(metodePembayaranPanel);
        metodePembayaranPanel.setLayout(metodePembayaranPanelLayout);
        metodePembayaranPanelLayout.setHorizontalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(metodePembayaranLabel)
                    .addComponent(bcaRadio)
                    .addComponent(mayRadio)
                    .addComponent(briRadio)
                    .addComponent(bpdRadio)
                    .addComponent(tunaiRadio))
                .addContainerGap(503, Short.MAX_VALUE))
        );
        metodePembayaranPanelLayout.setVerticalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(metodePembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bcaRadio)
                .addGap(5, 5, 5)
                .addComponent(briRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mayRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bpdRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tunaiRadio)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tablePembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePembelian);

        simpanTransaksiButton.setBackground(new java.awt.Color(51, 178, 73));
        simpanTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        simpanTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanTransaksiButton.setText("Simpan");
        simpanTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanTransaksiButtonActionPerformed(evt);
            }
        });

        batalTransaksiButton.setBackground(new java.awt.Color(237, 8, 0));
        batalTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        batalTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        batalTransaksiButton.setText("Batalkan");
        batalTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalTransaksiButtonActionPerformed(evt);
            }
        });

        reportPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportPanel.setForeground(new java.awt.Color(255, 255, 255));

        reportLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        reportLabel.setText("Laporan Keuangan");

        reportTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addComponent(reportLabel)
                        .addGap(0, 165, Short.MAX_VALUE))
                    .addComponent(reportTextField))
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addComponent(reportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout transaksiFormPanelLayout = new javax.swing.GroupLayout(transaksiFormPanel);
        transaksiFormPanel.setLayout(transaksiFormPanelLayout);
        transaksiFormPanelLayout.setHorizontalGroup(
            transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiFormPanelLayout.createSequentialGroup()
                        .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(namaCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(namaKendaraanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(namaLayananPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jumlahPembelianPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transaksiButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                                .addComponent(checkboxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(metodePembayaranPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiFormPanelLayout.createSequentialGroup()
                                        .addComponent(simpanTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(batalTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(354, 354, 354))))
                            .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        transaksiFormPanelLayout.setVerticalGroup(
            transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transaksiButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                        .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(metodePembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkboxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jumlahPembelianPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(batalTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(simpanTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                        .addComponent(namaCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaKendaraanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaLayananPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );

        javax.swing.GroupLayout searchTransaksiInputPanelLayout = new javax.swing.GroupLayout(searchTransaksiInputPanel);
        searchTransaksiInputPanel.setLayout(searchTransaksiInputPanelLayout);
        searchTransaksiInputPanelLayout.setHorizontalGroup(
            searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTransaksiInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                        .addGroup(searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                                .addComponent(searchTransaksiInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchTransaksiInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(transaksiFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 467, Short.MAX_VALUE)))
                .addContainerGap())
        );
        searchTransaksiInputPanelLayout.setVerticalGroup(
            searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTransaksiInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTransaksiInputTextField)
                    .addComponent(searchTransaksiInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transaksiFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTransaksiInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTransaksiInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 867, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahTransaksiButtonActionPerformed
        action = "tambah";
        setComponent(true);
        setRadioComponent(true);
    }//GEN-LAST:event_tambahTransaksiButtonActionPerformed

    private void hapusTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusTransaksiButtonActionPerformed
        action = "hapus";

        if(JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?") == JOptionPane.CLOSED_OPTION)
            return;

        pembelianControl.deletePembelianKendaraan(selectedId);

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        tambahTransaksiButton.setEnabled(true);
        showTableBySearch(""); 
        refreshReport();
    }//GEN-LAST:event_hapusTransaksiButtonActionPerformed

    private void barukanTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanTransaksiButtonActionPerformed
        action = "baharui";
        setComponent(true);
        namaCustomerDropdown.setEnabled(true);
        setEditDeleteBtn(true);
        setRadioComponent(false);
    }//GEN-LAST:event_barukanTransaksiButtonActionPerformed

    private void searchTransaksiInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransaksiInputButtonActionPerformed
        showTableBySearch(searchTransaksiInputTextField.getText());

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        tambahTransaksiButton.setEnabled(true);
    }//GEN-LAST:event_searchTransaksiInputButtonActionPerformed

    private void searchTransaksiInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTransaksiInputTextFieldKeyPressed

    }//GEN-LAST:event_searchTransaksiInputTextFieldKeyPressed

    private void namaKendaraanDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKendaraanDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKendaraanDropdownActionPerformed

    private void simpanTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTransaksiButtonActionPerformed
        try{
            // EXCEPTION
            inputKosongPembelianException();

            // SET ATRIBUT DAN METODE PEMBAYARAN
            String atribut = "";
            String metodePembayaran = "";

            // MENCARI INDEX YANG DITUJU OLEH DROPDOWN
            // CUSTOMER
            int selectedIndexCustomer = namaCustomerDropdown.getSelectedIndex();
            Customer selectedCustomer = listCustomer.get(selectedIndexCustomer);

            // KENDARAAN
            int selectedIndexKendaraan = namaKendaraanDropdown.getSelectedIndex();
            Kendaraan selectedKendaraan = listKendaraan.get(selectedIndexKendaraan);
            
            int selectedIndexLayanan = namaLayananDropdown.getSelectedIndex();
            LayananServis selectedLayanan = listLayanan.get(selectedIndexLayanan);

            double totalHarga = Integer.parseInt(jumlahPembelianInput.getText()) * selectedKendaraan.getHarga();

            if(ManualCheckbox.isSelected()){
                atribut = "Manual";
            }else{
                atribut = "Otomatis";
            }

            metodePembayaran = metodePembayaranGroup.getSelection().getActionCommand();

            if(JOptionPane.showConfirmDialog(rootPane, "Total pembayaran yang perlu Anda bayarkan adalah : Rp. " + totalHarga) != JOptionPane.CLOSED_OPTION){
                if(action.equals("tambah")){
                    PembelianKendaraan pk = new PembelianKendaraan(selectedCustomer.getId_customer(), Integer.parseInt(jumlahPembelianInput.getText()),
                            selectedKendaraan.getId_kendaraan(), selectedLayanan.getIdLayanan(),  atribut, metodePembayaran, selectedCustomer, selectedKendaraan, selectedLayanan);
                    pembelianControl.insertDataPembelianKendaraan(pk);
                } else {
                    PembelianKendaraan pk = new PembelianKendaraan(selectedCustomer.getId_customer(), Integer.parseInt(jumlahPembelianInput.getText()),
                            selectedKendaraan.getId_kendaraan(), selectedLayanan.getIdLayanan(), atribut, metodePembayaran, selectedCustomer, selectedKendaraan, selectedLayanan);
                    pembelianControl.updatePembelianKendaraan(pk, selectedId);
                    selectedId = -1;
                }
            }
        }catch(InputKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        tambahTransaksiButton.setEnabled(true);
        refreshReport();
        showTableBySearch("");       
    }//GEN-LAST:event_simpanTransaksiButtonActionPerformed

    private void jumlahPembelianInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPembelianInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahPembelianInputActionPerformed

    private void briRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_briRadioActionPerformed

    private void batalTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalTransaksiButtonActionPerformed
        clearText();
        setEditDeleteBtn(false);
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        
        tambahTransaksiButton.setEnabled(true);
    }//GEN-LAST:event_batalTransaksiButtonActionPerformed

    private void tablePembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePembelianMouseClicked
        int indexCustomer = -1, indexKendaraan = -1, indexLayanan = -1;
        action = "baharui";
        
        tambahTransaksiButton.setEnabled(false);
        batalTransaksiButton.setEnabled(true);
        simpanTransaksiButton.setEnabled(true);
        setEditDeleteBtn(true);

        setComponent(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();

        int clickedRow = tablePembelian.getSelectedRow();
        TableModel tableModel = tablePembelian.getModel();

        selectedId = Integer.parseInt(tableModel.getValueAt(clickedRow, 0).toString());
        jumlahPembelianInput.setText(tableModel.getValueAt(clickedRow, 3).toString());

        String metodePembayaran = tableModel.getValueAt(clickedRow, 5).toString();
        String atribut = tableModel.getValueAt(clickedRow, 4).toString();

        switch(metodePembayaran){
            case "BCA" :
                bcaRadio.setSelected(true);
                break;
            case "BRI" :
                briRadio.setSelected(true);
                break;
            case "May Bank":
                mayRadio.setSelected(true);
                break;
            case "BPD DIY":
                bpdRadio.setSelected(true);
                break;
            case "Tunai":
                tunaiRadio.setSelected(true);
                break;
        }

        ManualCheckbox.setSelected(false);
        OtomatisCheckbox.setSelected(false);

        switch(atribut){
            case "Otomatis" :
                OtomatisCheckbox.setSelected(true);
                break;
            case "Manual" :
                ManualCheckbox.setSelected(true);
                break;
        }

        for(Customer customer : listCustomer){
            if(customer.getNama().equals(tableModel.getValueAt(clickedRow, 1).toString())){
                indexCustomer = listCustomer.indexOf(customer);
            }
        }

        for(Kendaraan kendaraan : listKendaraan){
            if(kendaraan.getId_kendaraan().equals(tableModel.getValueAt(clickedRow, 2).toString())){
                indexKendaraan = listKendaraan.indexOf(kendaraan);
            }
        }

        for(LayananServis layanan : listLayanan){
            if(layanan.getNamaLayanan().equals(tableModel.getValueAt(clickedRow, 6).toString())) {
                indexLayanan = listKendaraan.indexOf(layanan);
            }
        }

        namaCustomerDropdown.setSelectedIndex(indexCustomer);
        namaKendaraanDropdown.setSelectedIndex(indexKendaraan);
        namaLayananDropdown.setSelectedIndex(indexLayanan);
        batalTransaksiButton.setEnabled(true);
    }//GEN-LAST:event_tablePembelianMouseClicked

    private void namaCustomerDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaCustomerDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaCustomerDropdownActionPerformed

    private void namaCustomerDropdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaCustomerDropdownMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_namaCustomerDropdownMouseClicked

    private void namaLayananDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaLayananDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaLayananDropdownActionPerformed

    private void ManualCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManualCheckboxActionPerformed

    private void reportTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ManualCheckbox;
    private javax.swing.JCheckBox OtomatisCheckbox;
    private javax.swing.JLabel atributLabel;
    private javax.swing.JButton barukanTransaksiButton;
    private javax.swing.JButton batalTransaksiButton;
    private javax.swing.JRadioButton bcaRadio;
    private javax.swing.JRadioButton bpdRadio;
    private javax.swing.JRadioButton briRadio;
    private javax.swing.JPanel checkboxPanel;
    private javax.swing.JButton hapusTransaksiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahLabel;
    private java.awt.TextField jumlahPembelianInput;
    private javax.swing.JPanel jumlahPembelianPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mayRadio;
    private javax.swing.ButtonGroup metodePembayaranGroup;
    private javax.swing.JLabel metodePembayaranLabel;
    private javax.swing.JPanel metodePembayaranPanel;
    private javax.swing.JComboBox<Customer> namaCustomerDropdown;
    private javax.swing.JLabel namaCustomerLabel;
    private javax.swing.JPanel namaCustomerPanel;
    private javax.swing.JComboBox<Kendaraan> namaKendaraanDropdown;
    private javax.swing.JLabel namaKendaraanLabel;
    private javax.swing.JPanel namaKendaraanPanel;
    private javax.swing.JComboBox<LayananServis> namaLayananDropdown;
    private javax.swing.JLabel namaLayananLabel;
    private javax.swing.JPanel namaLayananPanel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JTextField reportTextField;
    private javax.swing.JButton searchTransaksiInputButton;
    private javax.swing.JLabel searchTransaksiInputLabel;
    private javax.swing.JPanel searchTransaksiInputPanel;
    private javax.swing.JTextField searchTransaksiInputTextField;
    private javax.swing.JButton simpanTransaksiButton;
    private javax.swing.JTable tablePembelian;
    private javax.swing.JButton tambahTransaksiButton;
    private javax.swing.JPanel transaksiButtonPanel;
    private javax.swing.JPanel transaksiFormPanel;
    private javax.swing.JRadioButton tunaiRadio;
    // End of variables declaration//GEN-END:variables
}
