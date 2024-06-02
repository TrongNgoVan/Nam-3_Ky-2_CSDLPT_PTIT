/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.bank.system;

import java.sql.*;
import java.util.Optional;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;




public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;
    @FXML
    private Label name;

    @FXML
    private Button home_btn;

    @FXML
    private Button Staff_btn;

    @FXML
    private Button Account_btn;
    
    @FXML
    private Button Customer_btn;
    @FXML
    private Button CT_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

   @FXML
    private Label home_totalKH;

    @FXML
    private Label home_totalNV;

    @FXML
    private Label home_totalTK;

    @FXML
    private Label home_totalcard;
    @FXML
    private BarChart<String, Number> home_chart;

    @FXML
    private AnchorPane Staff_form;

    @FXML
    private TableView<Staff> Staff_tableView;

    @FXML
    private TableColumn<Staff, String> Staff_col_ID;

    @FXML
    private TableColumn<Staff, String> Staff_col_Name;

    @FXML
    private TableColumn<Staff, String> Staff_col_Dp;

    @FXML
    private TableColumn<Staff, String> Staff_col_gender;

    @FXML
    private TableColumn<Staff, String> Staff_col_phoneNum;

    @FXML
    private TableColumn<Staff, String> Staff_col_position;

    @FXML
    private TableColumn<Staff, String> Staff_col_date;
     @FXML
    private TableColumn<Staff, String> Staff_col_CCCD;

    @FXML
    private TextField Staff_search;
  
    @FXML
    private TextField Staff_ID;

    @FXML
    private TextField Staff_Name;

    @FXML
    private ComboBox<String> Staff_Dp;

    @FXML
    private ComboBox<String> Staff_gender;

    @FXML
    private TextField Staff_phoneNum;

    @FXML
    private ComboBox<String> Staff_position;
    @FXML
    private DatePicker Staff_dob;
     
    @FXML
    private TextField Staff_CCCD;

    @FXML
    private Button Staff_addBtn;

    @FXML
    private Button Staff_updateBtn;

    @FXML
    private Button Staff_deleteBtn;

    @FXML
    private Button Staff_clearBtn;

    @FXML
    private AnchorPane Account_form;
    
    @FXML
    private Label Account_CCCD;

    @FXML
    private Label Account_Name;

    @FXML
    private TextField Account_STK;

    @FXML
    private TextField Account_Sodu;
   
     @FXML
    private Label Account_date;

    
     @FXML
    private ComboBox<String> Account_Dp;
    @FXML
    private TextField Account_kh;
     @FXML
    private Button Account_addBtn;
    
    
    

    @FXML
    private Button Account_updateBtn;

    @FXML
    private Button Account_clearBtn;

    @FXML
    private TableView<Account> Account_tableView;

    @FXML
    private TableColumn<Account, String> Account_col_ID;

    @FXML
    private TableColumn<Account, String> Account_col_Name;

    @FXML
    private TableColumn<Account, String> Account_col_CCCD;

    @FXML
    private TableColumn<Account, String>  Account_col_Sodu;

    @FXML
    private TableColumn<Account, String>  Account_col_date;
    
    @FXML
    private TableColumn<Account, String>  Account_col_dp;
    
    @FXML
    private TableColumn<Account, String>  Account_col_kh;
    
   
    @FXML
    private ComboBox<String> Customer_Dp;
    @FXML
    private Button Customer_addBtn;
  
    @FXML
    private AnchorPane Customer_form;
    @FXML
    private TextField Customer_CCCD;

    @FXML
    private DatePicker Customer_Dob;

    @FXML
    private DatePicker Customer_Day;

    

    @FXML
    private TextField Customer_ID;

    @FXML
    private TextField Customer_Name;
    
    @FXML
    private TextField  Customer_Add;
    
    @FXML
    private ComboBox<String> Customer_gt;
     @FXML
    private TextField  Customer_sdt;

    @FXML
    private Button Customer_updateBtn;

    @FXML
    private Button Customer_clearBtn;
    
    @FXML
    private Button CR_btn;

    @FXML
    private TableView<Customer> Customer_tableView;

    @FXML
    private TableColumn<Customer, String> Customer_col_ID;

    @FXML
    private TableColumn<Customer, String> Customer_col_Name;

    @FXML
    private TableColumn<Customer, String> Customer_col_CCCD;

    @FXML
    private TableColumn<Customer, String> Customer_col_Day;

    @FXML
    private TableColumn<Customer, String> Customer_col_Dob;
    
    @FXML
    private TableColumn<Customer, String> Customer_col_Add;
    
    @FXML
    private TableColumn<Customer, String> Customer_col_Dp;
    
    @FXML
    private TableColumn<Customer, String> Customer_col_gt;
    
     @FXML
    private TableColumn<Customer, String> Customer_col_sdt;
    
     @FXML
    private Button CR_addBtn;

    @FXML
    private Button CR_clearBtn;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_day;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_id;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_loai;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_money;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_nv;

    @FXML
    private TableColumn<TransactionCR, String> CR_col_stk;

    @FXML
    private Button CR_deleteBtn;

    @FXML
    private AnchorPane CR_form;

    @FXML
    private TextField CR_id;

    @FXML
    private ComboBox<String> CR_loai;

    @FXML
    private TextField CR_money;

    @FXML
    private TextField CR_search;

    @FXML
    private TextField CR_stk;

    @FXML
    private TableView<TransactionCR> CR_tableView;

    @FXML
    private Button GD_addBtn;

    @FXML
    private Button GD_clearBtn;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_day;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_id;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_money;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_nv;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_stk1;

    @FXML
    private TableColumn<TransactionGD,String> GD_col_stk2;

    @FXML
    private Button GD_deleteBtn;

    @FXML
    private AnchorPane GD_form;

    @FXML
    private TextField GD_id;

    @FXML
    private TextField GD_money;

    @FXML
    private TextField GD_search;

    @FXML
    private TextField GD_stk1;

    @FXML
    private TextField GD_stk2;

    @FXML
    private TableView<TransactionGD> GD_tableView;

    @FXML
    private Button GD_updateBtn;
    @FXML
    private Button GD_btn;

    @FXML
    private Button CR_updateBtn;
    
    @FXML
    private Label Chucvu;
    @FXML
    private Button CD_btn;
   
    @FXML
    private Button dp_btn;
    
    @FXML
    private TextField DP_ADD;

    @FXML
    private TextField DP_ID;

    @FXML
    private TextField DP_Name;

    @FXML
    private TextField DP_SDT;

    @FXML
    private Button DP_addBtn;

    @FXML
    private Button DP_clearBtn;

    @FXML
    private TableColumn<Dp, String> DP_col_ADD;

    @FXML
    private TableColumn<Dp, String> DP_col_ID;

    @FXML
    private TableColumn<Dp, String> DP_col_Name;

    @FXML
    private TableColumn<Dp, String> DP_col_SDT;

    @FXML
    private AnchorPane DP_form;

    @FXML
    private TableView<Dp> DP_tableView;

    @FXML
    private Button DP_updateBtn;
    @FXML
    private TextField CardType_ID;

    @FXML
    private TextField CardType_Name;

    @FXML
    private Button CardType_addBtn;

    @FXML
    private Button CardType_clearBtn;

    @FXML
    private TableColumn<CardType, String> CardType_col_ID;

    @FXML
    private TableColumn<CardType, String> CardType_col_Name;

    @FXML
    private AnchorPane CardType_form;
    @FXML
    private Button CardType_btn;
     
    @FXML
    private Button Card_btn;
    @FXML
    private Button Card_updateBtn;
    @FXML
    private TableView<CardType> CardType_tableView;

    @FXML
    private Button CardType_updateBtn;
     @FXML
    private Label Card_Date;

    @FXML
    private TextField Card_ID;

    @FXML
    private TextField Card_IDAC;

    @FXML
    private ComboBox<String> Card_IDCT;

    @FXML
    private Label Card_Name;

    @FXML
    private Label Card_NameCT;

    @FXML
    private Button Card_addBtn;

   
    @FXML
    private Button Card_clearBtn;

    @FXML
    private TableColumn<Card, String> Card_col_Date;

    @FXML
    private TableColumn<Card, String> Card_col_ID;

    @FXML
    private TableColumn<Card, String> Card_col_IDAC;

    @FXML
    private TableColumn<Card, String> Card_col_IDCT;

    @FXML
    private TableColumn<Card, String> Card_col_Name;

    @FXML
    private TableColumn<Card, String> Card_col_NameCT;

    @FXML
    private AnchorPane Card_form;

    @FXML
    private TableView<Card> Card_tableView;



    
    
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private Image image;

    public void homeTotalNV()  {

       
            
        String sql = "SELECT COUNT(ID) AS total FROM Staff";
        int countData = 0;

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countData = result.getInt("total");
            }

            home_totalNV.setText(String.valueOf(countData));
        } catch (Exception e) {
            e.printStackTrace();
        } 
            
       

    }

    public void homeTotalKH() {

        String sql = "SELECT COUNT(ID) AS total FROM Customer";
        int countData = 0;

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            statement = connect.createStatement();
            result = statement.executeQuery(sql);

            if (result.next()) {
                countData = result.getInt("total");
            }

            home_totalKH.setText(String.valueOf(countData));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeTotalTK() {

       String sql = "SELECT COUNT(STK) AS total FROM Account";
        int countData = 0;

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countData = result.getInt("total");
            }

            home_totalTK.setText(String.valueOf(countData));
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
 
     public void homeTotalCard() {

       String sql = "SELECT COUNT(ID_Card) AS total FROM Card";
        int countData = 0;

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countData = result.getInt("total");
            }

            home_totalcard.setText(String.valueOf(countData));
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        home_chart = new BarChart<>(xAxis, yAxis);
        home_chart.setTitle("Thống kê giao dịch gửi/rút tiền theo trụ sở");
        xAxis.setLabel("Trụ sở");
        yAxis.setLabel("Số lượng giao dịch");

        Pane root = new Pane();
        root.getChildren().add(home_chart);

        homeChart();

        Scene scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    public void homeChart() {
        home_chart.getData().clear();

        String sqlRutTien = "{CALL dbo.Total_GD_RutMoney_Dp()}";
        String sqlGuiTien = "{CALL dbo.Total_GD_SendMoney_Dp()}";

        Connection connect;
        CallableStatement callableStatementRutTien;
        CallableStatement callableStatementGuiTien;
        ResultSet resultRutTien;
        ResultSet resultGuiTien;

        XYChart.Series<String, Number> seriesRutTien = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesGuiTien = new XYChart.Series<>();

        seriesRutTien.setName("Rút tiền");
        seriesGuiTien.setName("Gửi tiền");

        try {
            connect = DatabaseConnectionManager.getConnection();

            // Lấy dữ liệu cho giao dịch rút tiền
            callableStatementRutTien = connect.prepareCall(sqlRutTien);
            resultRutTien = callableStatementRutTien.executeQuery();
            while (resultRutTien.next()) {
                String nameHq = resultRutTien.getString("name");
                int numberTransaction = resultRutTien.getInt("number_transactionRutTien");
                double totalMoney = resultRutTien.getDouble("total_money");
                XYChart.Data<String, Number> data = new XYChart.Data<>(nameHq, numberTransaction);
                seriesRutTien.getData().add(data);
                // Thêm tổng số tiền lên trên đầu cột
                addDataLabel(data, totalMoney);
            }

            // Lấy dữ liệu cho giao dịch gửi tiền
            callableStatementGuiTien = connect.prepareCall(sqlGuiTien);
            resultGuiTien = callableStatementGuiTien.executeQuery();
            while (resultGuiTien.next()) {
                String nameHq = resultGuiTien.getString("name");
                int numberTransaction = resultGuiTien.getInt("number_transactionCT");
                double totalMoney = resultGuiTien.getDouble("total_money");
                XYChart.Data<String, Number> data = new XYChart.Data<>(nameHq, numberTransaction);
                seriesGuiTien.getData().add(data);
                // Thêm tổng số tiền lên trên đầu cột
                addDataLabel(data, totalMoney);
            }

            // Thêm dữ liệu vào biểu đồ
            home_chart.getData().addAll(seriesRutTien, seriesGuiTien);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addDataLabel(XYChart.Data<String, Number> data, double totalMoney) {
        Label label = new Label(String.format("%.0f VNĐ", totalMoney));
        Pane chartParent = (Pane) home_chart.getParent();
        chartParent.getChildren().add(label);

        data.nodeProperty().addListener((obs, oldNode, newNode) -> {
            if (newNode != null) {
                newNode.boundsInParentProperty().addListener((observable, oldBounds, newBounds) -> {
                    label.setLayoutX(newBounds.getMinX() + 30 + (newBounds.getWidth() - label.getWidth()) / 2);
                    label.setLayoutY(newBounds.getMinY() - label.getHeight() + 270);
                });
            }
        });
    }


public void CardAdd() {
    if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền thêm thẻ!");
        alert.showAndWait();
        return;
    }

    String sql = "INSERT INTO Card (ID_Card, TenChuthe, [Date Expired], Name_CardType, ID_CardType, ID_ac) VALUES (?, ?, ?, ?, ?, ?)";

    try {
        Alert alert;
        Connection connect = DatabaseConnectionManager.getConnection();

        if (Card_ID.getText().isEmpty() || 
                Card_IDCT.getSelectionModel().getSelectedItem() == null || Card_IDAC.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            String check = "SELECT ID_Card FROM Card WHERE ID_Card = '" + Card_ID.getText() + "'";
            statement = connect.createStatement();
            result = statement.executeQuery(check);

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("ID Thẻ: " + Card_ID.getText() + " đã tồn tại!");
                alert.showAndWait();
            } else {
                
             
                String check2 = "SELECT * FROM Account WHERE STK = '" + Card_IDAC.getText() + "'";
                Statement statement2 = connect.createStatement();
                ResultSet  result2 = statement2.executeQuery(check2);
                
                String check3 = "SELECT * FROM CardType WHERE ID_CardType = '" + Card_IDCT.getSelectionModel().getSelectedItem() + "'";
                Statement statement3 = connect.createStatement();
                ResultSet  result3 = statement3.executeQuery(check3);
                
                if (!result2.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Không tìm thấy STK" + Card_IDAC.getText());
                alert.showAndWait();
               }else if(result3.next()){

                
                Date currentDate = new Date(System.currentTimeMillis());
                long fiveYearsInMillis = 5L * 365 * 24 * 60 * 60 * 1000;
                Date expiryDate = new Date(currentDate.getTime() + fiveYearsInMillis);

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, Card_ID.getText());
                prepare.setString(2, result2.getString("name"));
               prepare.setDate(3, new java.sql.Date(expiryDate.getTime()));

                prepare.setString(4, result3.getString("name"));
                prepare.setString(5, Card_IDCT.getSelectionModel().getSelectedItem());
                prepare.setString(6, Card_IDAC.getText());

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Thêm Thẻ thành công!");
                alert.showAndWait();

                CardShowListData();
                CardReset();
                }
            }
        }
    } catch (Exception e) {
        showErrorAlert("ERROR: ", e.getMessage());
    }
}

public void CardUpdate() {
    if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền update thẻ!");
        alert.showAndWait();
        return;
    } else {
        String sql = "UPDATE Card SET TenChuthe = ?, [Date Expired] = ?, Name_CardType = ?, ID_CardType = ?, ID_ac = ? WHERE ID_Card = ?";

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            Alert alert;
            if (Card_ID.getText().isEmpty()  || 
                    Card_IDCT.getSelectionModel().getSelectedItem() == null || Card_IDAC.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin!");
                alert.showAndWait();
            } else {
                
                String check2 = "SELECT * FROM Account WHERE STK = '" + Card_IDAC.getText() + "'";
                Statement statement2 = connect.createStatement();
                ResultSet  result2 = statement2.executeQuery(check2);
                
                String check3 = "SELECT * FROM CardType WHERE ID_CardType = '" + Card_IDCT.getSelectionModel().getSelectedItem() + "'";
                Statement statement3 = connect.createStatement();
                ResultSet  result3 = statement3.executeQuery(check3);
                
                if (!result2.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Không tìm thấy STK" + Card_IDAC.getText());
                alert.showAndWait();
               }else if(result3.next()) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc chắn muốn UPDATE Thẻ ID: " + Card_ID.getText() + "?");
                java.util.Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Date currentDate = new Date(System.currentTimeMillis());
                    long fiveYearsInMillis = 5L * 365 * 24 * 60 * 60 * 1000;
                    Date expiryDate = new Date(currentDate.getTime() + fiveYearsInMillis);

                    PreparedStatement prepare = connect.prepareStatement(sql);
                    prepare.setString(1, result2.getString("name"));
                    prepare.setDate(2, new java.sql.Date(expiryDate.getTime()));

                    prepare.setString(3,result3.getString("name"));
                    prepare.setString(4, Card_IDCT.getSelectionModel().getSelectedItem());
                    prepare.setString(5, Card_IDAC.getText());
                    prepare.setString(6, Card_ID.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update thông tin thành công!");
                    alert.showAndWait();
                  CardShowListData();
                    CardReset();
                }
            }
          }
        } catch (Exception e) {
            showErrorAlert("ERROR: ", e.getMessage());
        }
    }
}

public void CardReset() {
    Card_ID.setText("");  
    Card_Name.setText("");
    Card_Date.setText("");
    Card_NameCT.setText("");
    Card_IDCT.getSelectionModel().clearSelection();
    Card_IDAC.setText("");
}

public ObservableList<Card> CardListData() {
    ObservableList<Card> listData = FXCollections.observableArrayList();
    String sql = "SELECT * FROM Card";    

    try {
        Connection connect = DatabaseConnectionManager.getConnection();
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        Card ct;

        while (result.next()) {
            ct = new Card(result.getString("ID_Card"),
                          result.getString("TenChuthe"),
                          result.getDate("Date Expired"),
                          result.getString("Name_CardType"),
                          result.getString("ID_CardType"),
                          result.getString("ID_ac"));
            listData.add(ct);
        }
    } catch (Exception e) {
        showErrorAlert("ERROR: ", e.getMessage());
    }
    return listData;
}

private ObservableList<Card> CardList;

public void CardShowListData() {
    CardList = CardListData();

    Card_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID_Card"));
    Card_col_Name.setCellValueFactory(new PropertyValueFactory<>("TenChuthe"));
        Card_col_Date.setCellValueFactory(param -> {
          Date dateExpired = param.getValue().getDateExpired();
          String formattedDate = ""; // Biến lưu trữ ngày đã định dạng

          if (dateExpired != null) {
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
              formattedDate = formatter.format(dateExpired);
          }

          return new SimpleStringProperty(formattedDate);
      });


    Card_col_NameCT.setCellValueFactory(new PropertyValueFactory<>("Name_CardType"));
    Card_col_IDCT.setCellValueFactory(new PropertyValueFactory<>("ID_CardType"));
    Card_col_IDAC.setCellValueFactory(new PropertyValueFactory<>("ID_ac"));
    
    Card_tableView.setItems(CardList);
}

public void CardSelect() {
    Card CardD = Card_tableView.getSelectionModel().getSelectedItem();
    int num = Card_tableView.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

    Card_ID.setText(CardD.getID_Card());
    Card_Name.setText(CardD.getTenChuthe());
    Card_Date.setText(CardD.getDateExpired().toString());
    Card_NameCT.setText(CardD.getName_CardType());
    Card_IDCT.getSelectionModel().select(CardD.getID_CardType());
    Card_IDAC.setText(CardD.getID_ac());
}
     public void CardTypeAdd() {
       
        if (!getData.id.equals("TSHN") ) {
               Alert alert;
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Chỉ có Quản Trị Viên của trụ sở Tổng Hà Nội mới có quyền thêm loại thẻ!");
                alert.showAndWait();
                return;
        }
        
        String sql = "INSERT INTO CardType "
                + "(ID_CardType,name) "
                + "VALUES(?,?)";


        try {
            Alert alert;
           

               Connection connect = DatabaseConnectionManager.getConnection();

            if (CardType_ID.getText().isEmpty()
                   
                    || CardType_Name.getText().isEmpty()
                   
                   ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin!");
                alert.showAndWait();
            } else {

                String check = "SELECT ID_CardType FROM CardType WHERE ID_CardType = '"
                        + CardType_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("ID Loại Thẻ: " + CardType_ID.getText() + " đã tồn tại !");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, CardType_ID.getText());         
                    prepare.setString(2,CardType_Name.getText()) ;
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm Loại Thẻ thành công!");
                    alert.showAndWait();
                    
                    CardTypeShowListData();
                    CardTypeReset();
                    
                    
                    
                }
            }

        } catch (Exception e) {
           
            showErrorAlert("ERROR: ", e.getMessage());
        }
       

    }

 public void CardTypeUpdate() {
       if (!getData.id.equals("TSHN")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Quản Trị Viên của trụ sở tổng Hà Nội mới có quyền sửa Loại Thẻ!");
        alert.showAndWait();
        return;
    }
        else{
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    String sql = "UPDATE CardType SET  name = ? WHERE ID_CardType = ?";

    try {
        Connection connect = DatabaseConnectionManager.getConnection();
        Alert alert;
        if (CardType_ID.getText().isEmpty()
              
                || CardType_Name.getText().isEmpty()
           
                
               ) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Bạn Có chắc chắn muốn UPDATE Loại Thẻ ID: " + CardType_ID.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                PreparedStatement prepare = connect.prepareStatement(sql);
                
                        
                prepare.setString(1,CardType_Name.getText()) ;
                prepare.setString(2, CardType_ID.getText());
              

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Update thông tin thành công!");
                alert.showAndWait();

                CardTypeShowListData();
                CardTypeReset();
            }
        }
    } catch (Exception e) {
         showErrorAlert("ERROR: ", e.getMessage());
    }
      }
}


   

    public void CardTypeReset() {
    CardType_ID.setText("");  
    CardType_Name.setText("");
   
}


    public ObservableList<CardType> CardTypeListData() {

        ObservableList<CardType> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM CardType";    

        try {
                Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            CardType ct;

            while (result.next()) {
                ct = new CardType(result.getString("ID_CardType"),
                       
                     result.getString("name"));                       
                listData.add(ct);
            }

        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }
    private ObservableList<CardType> CardTypeList;

    public void CardTypeShowListData() {
        CardTypeList = CardTypeListData();

        CardType_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID_CardType"));
        CardType_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        CardType_tableView.setItems(CardTypeList);

    }

    public void CardTypeSelect() {
        CardType CardTypeD = CardType_tableView.getSelectionModel().getSelectedItem();
        int num = CardType_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        CardType_ID.setText(String.valueOf(CardTypeD.getID_CardType()));
        CardType_Name.setText(CardTypeD.getName());
    }
    
       public void DPAdd() {
       
        if (getData.id.equals("TSHN") || getData.chucvu.equals("Giao Dịch Viên")) {
               Alert alert;
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Chỉ có Quản Trị Viên của trụ sở con mới có quyền thêm chi nhánh tương ứng với trụ sở đó!");
                alert.showAndWait();
                return;
        }
        
        String sql = "INSERT INTO Dp "
                + "(ID_dp,adress,name,hotline,ID_HQ) "
                + "VALUES(?,?,?,?,?)";


        try {
            Alert alert;
           

               Connection connect = DatabaseConnectionManager.getConnection();

            if (DP_ID.getText().isEmpty()
                    || DP_ADD.getText().isEmpty()
                    || DP_Name.getText().isEmpty()
                    || DP_SDT.getText().isEmpty()
                   ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin!");
                alert.showAndWait();
            } else {

                String check = "SELECT ID_dp FROM Dp WHERE ID_dp = '"
                        + DP_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("ID Chi Nhánh: " + DP_ID.getText() + " đã tồn tại !");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, DP_ID.getText());
                    prepare.setString(2, DP_ADD.getText());              
                    prepare.setString(3,DP_Name.getText()) ;
                    prepare.setString(4, DP_SDT.getText());
                    prepare.setString(5, getData.id);

                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm Chi Nhánh thành công!");
                    alert.showAndWait();
                    
                    DPShowListData();
                    DPReset();
                    
                    
                    
                }
            }

        } catch (Exception e) {
           
            showErrorAlert("ERROR: ", e.getMessage());
        }
       

    }

 public void DPUpdate() {
       if (getData.id.equals("TSHN") || getData.chucvu.equals("Giao Dịch Viên")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Quản Trị Viên của trụ sở con mới có quyền sửa nhân viên tương ứng với trụ sở đó!");
        alert.showAndWait();
        return;
    }
        else{
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    String sql = "UPDATE DP SET adress = ?, name = ?, hotline= ? WHERE ID_dp = ?";

    try {
        Connection connect = DatabaseConnectionManager.getConnection();
        Alert alert;
        if (DP_ID.getText().isEmpty()
                || DP_ADD.getText().isEmpty()
                || DP_Name.getText().isEmpty()
                || DP_SDT.getText().isEmpty()
                
               ) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Bạn Có chắc chắn muốn UPDATE Chi Nhánh ID: " + DP_ID.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                PreparedStatement prepare = connect.prepareStatement(sql);
                
                prepare.setString(1, DP_ADD.getText());              
                prepare.setString(2,DP_Name.getText()) ;
                prepare.setString(3, DP_SDT.getText());
                prepare.setString(4, DP_ID.getText());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Update thông tin thành công!");
                alert.showAndWait();

                DPShowListData();
                DPReset();
            }
        }
    } catch (Exception e) {
         showErrorAlert("ERROR: ", e.getMessage());
    }
      }
}


   

    public void DPReset() {
    DP_ID.setText("");
    DP_ADD.setText("");
    DP_Name.setText("");
    DP_SDT.setText("");
   
}


    public ObservableList<Dp> DPListData() {

        ObservableList<Dp> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Dp";

    

        try {
                Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Dp cn;

            while (result.next()) {
                cn = new Dp(result.getString("ID_dp"),
                        result.getString("adress"),
                        result.getString("name"),
                        result.getString("hotline"),
                        result.getString("ID_HQ"));                       
                listData.add(cn);
            }

        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }
    private ObservableList<Dp> DPList;

    public void DPShowListData() {
        DPList = DPListData();

        DP_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID_dp"));
        DP_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        DP_col_ADD.setCellValueFactory(new PropertyValueFactory<>("adress"));
        DP_col_SDT.setCellValueFactory(new PropertyValueFactory<>("hotline"));
        DP_tableView.setItems(DPList);

    }

    public void DPSelect() {
        Dp DPD = DP_tableView.getSelectionModel().getSelectedItem();
        int num = DP_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        DP_ID.setText(String.valueOf(DPD.getID_dp()));
        DP_Name.setText(DPD.getName());
        DP_ADD.setText(DPD.getAdress());
        DP_SDT.setText(DPD.getHotline());
        
        

        

    }

    public void StaffAdd() {
       
        if (getData.id.equals("TSHN") || getData.chucvu.equals("Giao Dịch Viên")) {
               Alert alert;
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Chỉ có Quản Trị Viên của trụ sở con mới có quyền thêm nhân viên tương ứng với trụ sở đó!");
                alert.showAndWait();
                return;
        }
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO Staff "
                + "(ID,name,Gioitinh,SDT,Dob,CCCD,Chucvu,ID_Dp) "
                + "VALUES(?,?,?,?,?,?,?,?)";


        try {
            Alert alert;
           

               Connection connect = DatabaseConnectionManager.getConnection();

            if (Staff_ID.getText().isEmpty()
                    || Staff_Name.getText().isEmpty()
                    || Staff_gender.getSelectionModel().getSelectedItem() == null
                    || Staff_phoneNum.getText().isEmpty()
                    || Staff_dob.getValue() == null
                    || Staff_CCCD.getText().isEmpty()
                    || Staff_position.getSelectionModel().getSelectedItem() == null
                    || Staff_Dp.getSelectionModel().getSelectedItem() == null
                   ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin!");
                alert.showAndWait();
            } else {

                String check = "SELECT ID FROM Staff WHERE ID = '"
                        + Staff_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff ID: " + Staff_ID.getText() + " đã tồn tại !");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, Staff_ID.getText());
                    prepare.setString(2, Staff_Name.getText());              
                    prepare.setString(3, (String) Staff_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(4, Staff_phoneNum.getText());
                    prepare.setDate(5, java.sql.Date.valueOf(Staff_dob.getValue()));
                    // biểu mẫu điền vào là ở dang localdate , getValue là để lấy giád trị của nó , 
                    // còn trong db mình đang để dang date , phải chuyển về dangj date mới đưa vào csdl được
                    // kinh nghiệm sau này ngày tháng nên để dạng localdate
                    prepare.setString(6,Staff_CCCD.getText());
                    prepare.setString(7, (String) Staff_position.getSelectionModel().getSelectedItem());
                    prepare.setString(8,Staff_Dp.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm Nhân viên thành công!");
                    alert.showAndWait();
                    
                    StaffShowListData();
                    StaffReset();
                    
                    
                    
                }
            }

        } catch (Exception e) {
           
            showErrorAlert("ERROR: ", e.getMessage());
        }
       

    }

 public void StaffUpdate() {
       if (getData.id.equals("TSHN") || getData.chucvu.equals("Giao Dịch Viên")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Quản Trị Viên của trụ sở con mới có quyền sửa nhân viên tương ứng với trụ sở đó!");
        alert.showAndWait();
        return;
    }
        else{
    Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    String sql = "UPDATE Staff SET name = ?, Gioitinh = ?, SDT= ?, Dob = ?, CCCD = ?, Chucvu = ?, ID_Dp = ? WHERE ID = ?";

    try {
        Connection connect = DatabaseConnectionManager.getConnection();
        Alert alert;
        if (Staff_ID.getText().isEmpty()
                || Staff_Name.getText().isEmpty()
                || Staff_gender.getSelectionModel().getSelectedItem() == null
                || Staff_phoneNum.getText().isEmpty()
                || Staff_dob.getValue() == null
                || Staff_CCCD.getText().isEmpty()
                || Staff_position.getSelectionModel().getSelectedItem() == null
                || Staff_Dp.getSelectionModel().getSelectedItem() == null
               ) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Staff ID: " + Staff_ID.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                PreparedStatement prepare = connect.prepareStatement(sql);
                prepare.setString(1, Staff_Name.getText());
                prepare.setString(2, Staff_gender.getSelectionModel().getSelectedItem());
                prepare.setString(3, Staff_phoneNum.getText());
                prepare.setDate(4, java.sql.Date.valueOf(Staff_dob.getValue()));
                prepare.setString(5, Staff_CCCD.getText());
                prepare.setString(6, Staff_position.getSelectionModel().getSelectedItem());
                prepare.setString(7, Staff_Dp.getSelectionModel().getSelectedItem());
                prepare.setString(8, Staff_ID.getText());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Update thông tin thành công!");
                alert.showAndWait();

                StaffShowListData();
                StaffReset();
            }
        }
    } catch (Exception e) {
         showErrorAlert("ERROR: ", e.getMessage());
    }
      }
}


 


    public void StaffReset() {
    Staff_ID.setText("");
    Staff_Name.setText("");
    Staff_gender.getSelectionModel().clearSelection();
    Staff_phoneNum.setText("");
    Staff_dob.setValue(null); // Đặt giá trị ngày tháng thành null
    Staff_CCCD.setText("");
    Staff_position.getSelectionModel().clearSelection();
    Staff_Dp.getSelectionModel().clearSelection();
}

    

    private String[] positionList = {"Giao Dịch Viên", "Quản Trị Viên"};
    private String[] dpList ;
    private String[] CTList;
    public void CardTypeList(){
        String sql = "SELECT * FROM CardType";
        try{
            Connection connect = DatabaseConnectionManager.getConnection();
              statement = connect.createStatement();
         result = statement.executeQuery(sql);
          List<String> listP = new ArrayList<>();
              while (result.next()) {
            listP.add(result.getString("ID_CardType"));
        }
             CTList = listP.toArray(new String[0]);
        }catch(SQLException e){
             showErrorAlert("ERROR: ", e.getMessage());
        }
    }
     public void CTypeList() {
    if (CTList == null || CTList.length == 0) {
        CardTypeList();
    }

    List<String> listP = new ArrayList<>(Arrays.asList(CTList));
    ObservableList<String> listData = FXCollections.observableArrayList(listP);
    Card_IDCT.setItems(listData);
}
   public void loadDpList() {
    String sql = "SELECT ID_dp FROM Dp";

    try  {
        Connection connect = DatabaseConnectionManager.getConnection();
          statement = connect.createStatement();
         result = statement.executeQuery(sql);

        List<String> listP = new ArrayList<>();
        
        while (result.next()) {
            listP.add(result.getString("ID_dp"));
        }

        // Chuyển List thành mảng và gán vào dpList
        dpList = listP.toArray(new String[0]);
    } catch (SQLException e) {
        showErrorAlert("ERROR: ", e.getMessage());
    }
}
   public void AccountDpList() {
    if (dpList == null || dpList.length == 0) {
        loadDpList();
    }

    List<String> listP = new ArrayList<>(Arrays.asList(dpList));
    ObservableList<String> listData = FXCollections.observableArrayList(listP);
    Account_Dp.setItems(listData);
}
public void CustomerDpList() {
    if (dpList == null || dpList.length == 0) {
        loadDpList();
    }

    List<String> listP = new ArrayList<>(Arrays.asList(dpList));
    ObservableList<String> listData = FXCollections.observableArrayList(listP);
    Customer_Dp.setItems(listData);
}

    public void StaffDpList() {
        if (dpList == null || dpList.length == 0) {
            loadDpList();
        }

        List<String> listP = new ArrayList<>(Arrays.asList(dpList));
        ObservableList<String> listData = FXCollections.observableArrayList(listP);
        Staff_Dp.setItems(listData);
    }

    public void StaffPositionList() {
        List<String> listP = new ArrayList<>();

        for (String data : positionList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        Staff_position.setItems(listData);
    }
     
    private String[] listGender = {"Nam", "Nữ"};

    public void StaffGendernList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        Staff_gender.setItems(listData);
    }

    public void StaffSearch() {
    FilteredList<Staff> filteredList = new FilteredList<>(StaffList, e -> true);

    Staff_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(employeeData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (employeeData.getID().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getName().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getID_Dp().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getGioitinh().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getSDT().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getChucvu().toLowerCase().contains(searchKey)) {
                return true;
            } else if (employeeData.getDob().toString().contains(searchKey)) {
                return true;
            } else if (employeeData.getCCCD().toLowerCase().contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<Staff> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(Staff_tableView.comparatorProperty());
    Staff_tableView.setItems(sortedList);
}


    public ObservableList<Staff> StaffListData() {

        ObservableList<Staff> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Staff";

    

        try {
                Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Staff staff;

            while (result.next()) {
                staff = new Staff(result.getString("ID"),
                        result.getString("name"),
                        result.getString("Gioitinh"),
                        result.getString("SDT"),
                        result.getDate("Dob"),
                        result.getString("CCCD"),
                        result.getString("Chucvu"),
                        result.getString("ID_Dp"));
                listData.add(staff);

            }

        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }
    private ObservableList<Staff> StaffList;

    public void StaffShowListData() {
        StaffList = StaffListData();

        Staff_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Staff_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Staff_col_Dp.setCellValueFactory(new PropertyValueFactory<>("ID_Dp"));
        Staff_col_gender.setCellValueFactory(new PropertyValueFactory<>("Gioitinh"));
        Staff_col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("SDT"));
        Staff_col_position.setCellValueFactory(new PropertyValueFactory<>("Chucvu"));
        Staff_col_date.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        Staff_col_CCCD.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        Staff_tableView.setItems(StaffList);

    }

    public void StaffSelect() {
        Staff StaffD = Staff_tableView.getSelectionModel().getSelectedItem();
        int num = Staff_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        Staff_ID.setText(String.valueOf(StaffD.getID()));
        Staff_Name.setText(StaffD.getName());
        Staff_Dp.getSelectionModel().select((String)StaffD.getID_Dp());
        Staff_phoneNum.setText(StaffD.getSDT());
        Staff_gender.getSelectionModel().select((String) StaffD.getGioitinh());
        Staff_position.getSelectionModel().select((String) StaffD.getChucvu());
        Date dobDate = StaffD.getDob(); // Giả sử dobDate là một đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
        String dobString = dateFormat.format(dobDate); // Chuyển đổi Date thành chuỗi
        LocalDate localDate = LocalDate.parse(dobString); // Chuyển đổi chuỗi thành LocalDate
        Staff_dob.setValue(localDate); // Đặt giá trị cho DatePicker
        Staff_CCCD.setText(StaffD.getCCCD());
        

        

    }
    public void AccountAdd() {
    // Kiểm tra quyền trước khi thực hiện bất kỳ thao tác nào khác
    if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền thêm Tài khoản tương ứng với trụ sở đó!");
        alert.showAndWait();
        return;
    }

   Date date = new Date(); // Lấy thời điểm hiện tại
    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime()); // Chuyển đổi thành Timestamp để lưu vào cột datetime trong SQL

    String sql = "INSERT INTO Account "
            + "(STK, name, CCCD, Sodu, Create_date, ID_Dp, ID_Customer) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

   
    Alert alert;

    try {
        connect = DatabaseConnectionManager.getConnection();

        // Kiểm tra các trường dữ liệu bắt buộc
        if (Account_STK.getText().isEmpty()
                || Account_Sodu.getText().isEmpty()
                || Account_Dp.getSelectionModel().getSelectedItem() == null
                || Account_kh.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
            return;
        }

        // Kiểm tra sự tồn tại của số tài khoản
         String check = "SELECT STK FROM Account WHERE STK = '"
                        + Account_STK.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);
       

        if (result.next()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Số tài khoản: " + Account_STK.getText() + " đã tồn tại !");
            alert.showAndWait();
        } else {
            
                String check2 = "SELECT * FROM Customer WHERE ID = '" + Account_kh.getText() + "'";
                Statement statement2 = connect.createStatement();
                ResultSet  result2 = statement2.executeQuery(check2);
                
                
                if (!result2.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Không tìm thấy Mã Khách Hàng" +  Account_kh.getText());
                alert.showAndWait();
               }else{

            // Thêm tài khoản mới
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, Account_STK.getText());
            prepare.setString(2, result2.getString("name"));
            prepare.setString(3, result2.getString("CCCD"));
            prepare.setString(4, Account_Sodu.getText());
            prepare.setTimestamp(5, sqlTimestamp);
            prepare.setString(6, Account_Dp.getSelectionModel().getSelectedItem());
            prepare.setString(7, Account_kh.getText());

            prepare.executeUpdate();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Thêm Tài Khoản thành công!");
            alert.showAndWait();

            // Cập nhật danh sách tài khoản và đặt lại biểu mẫu
            AccountShowListData();
            AccountReset();
               }
        }
    } catch (Exception e) {
        showErrorAlert("ERROR: ", e.getMessage());
    } 
}

    public void AccountUpdate() {
        if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền Mở Tài Khoản tương ứng với trụ sở đó!");
            alert.showAndWait();
            return;
    }

    

    
        try {
            Alert alert;
               Connection connect = DatabaseConnectionManager.getConnection();

            if (Account_STK.getText().isEmpty()
                    || Account_Name.getText().isEmpty()
                    || Account_CCCD.getText().isEmpty()
                    || Account_Sodu.getText().isEmpty()                   
                     || Account_Dp.getSelectionModel().getSelectedItem() == null
                     || Account_kh.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin");
                alert.showAndWait();
            } else {
                  String check2 = "SELECT * FROM Customer WHERE ID = '" + Account_kh.getText() + "'";
                Statement statement2 = connect.createStatement();
                ResultSet  result2 = statement2.executeQuery(check2);
                
                
                if (!result2.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Không tìm thấy Mã Khách Hàng" +  Account_kh.getText());
                alert.showAndWait();
               }else{
                      String sql = "UPDATE Account SET name = '" + result2.getString("name")
                + "', CCCD = '" + result2.getString("CCCD")
                + "', Sodu = '" + Account_Sodu.getText()
                + "', ID_Dp = '" + Account_Dp.getSelectionModel().getSelectedItem()
                + "', ID_Customer = '" + Account_kh.getText()               
                + "' WHERE STK = '" + Account_STK.getText() + "'";
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Update thông tin thành công!");
                alert.showAndWait();

                AccountShowListData();
                }
            }

        } catch (Exception e) {
           showErrorAlert("ERROR: ", e.getMessage());
        }
    }

    public void AccountReset() {
        Account_STK.setText("");
        Account_Name.setText("");
        Account_CCCD.setText("");
        Account_Sodu.setText("");
        Account_date.setText("");
        Account_Dp.getSelectionModel().clearSelection();
        Account_kh.setText("");
        
    }

    public ObservableList<Account> AccountListData() {


        ObservableList<Account> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Account";

       

        try {
            Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
             Account tk;

            while (result.next()) {
                tk = new Account(result.getString("STK"),
                        result.getString("name"),
                        result.getString("CCCD"),
                        result.getString("Sodu"),
                        result.getDate("Create_date"),
                        result.getString("ID_Dp"),
                        result.getString("ID_Customer"));
                listData.add(tk);

            }

        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }

    private ObservableList<Account> AccountList;

    public void AccountShowListData() {
        AccountList = AccountListData();

        Account_col_ID.setCellValueFactory(new PropertyValueFactory<>("STK"));
        Account_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Account_col_CCCD.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
         Account_col_Sodu.setCellValueFactory(new PropertyValueFactory<>("Sodu"));
         Account_col_date.setCellValueFactory(new PropertyValueFactory<>("Create_date"));
         Account_col_dp.setCellValueFactory(new PropertyValueFactory<>("ID_Dp"));
         Account_col_kh.setCellValueFactory(new PropertyValueFactory<>("ID_Customer"));
        Account_tableView.setItems(AccountList);

    }

    public void AccountSelect() {

         Account tk = Account_tableView.getSelectionModel().getSelectedItem();
        int num = Account_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        Account_STK.setText(String.valueOf(tk.getSTK()));
        Account_Name.setText(String.valueOf(tk.getName()));
        Account_CCCD.setText(String.valueOf(tk.getCCCD()));
        Account_Sodu.setText(String.valueOf(tk.getSodu()));
        
        Account_date.setText(String.valueOf(tk.getCreate_date()));;
        Account_Dp.getSelectionModel().select((String)tk.getID_Dp());
        Account_kh.setText(String.valueOf(tk.getID_Customer()));
       

    }
    
    public void CustomerGendernList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        Customer_gt.setItems(listData);
    }
    public void CustomerAdd() {
    if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền thêm Khách hàng tương ứng với trụ sở đó!");
        alert.showAndWait();
        return;
    }

    String sql = "INSERT INTO Customer "
            + "(ID, name, CCCD, Ngaycap,Dob, adress, Sdt, ID_Dp,gender) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try  {
        Connection connect = DatabaseConnectionManager.getConnection();
      
          
        // Kiểm tra các trường dữ liệu bắt buộc
        if (Customer_ID.getText().isEmpty()
                || Customer_Name.getText().isEmpty()
                || Customer_CCCD.getText().isEmpty()
                ||Customer_Day.getValue() == null
                || Customer_Dob.getValue() == null
                || Customer_Add.getText().isEmpty()
                || Customer_sdt.getText().isEmpty()
                || Customer_Dp.getSelectionModel().getSelectedItem() == null
                || Customer_gt.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
            return;
        }else{
                String check = "SELECT ID FROM Customer WHERE ID = '"
                        + Customer_ID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);
        // Kiểm tra sự tồn tại của khách hàng
     
        
            if (result.next()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Mã khách hàng: " + Customer_ID.getText() + " đã tồn tại !");
                alert.showAndWait();
                return;
            }else{
        

        // Thêm khách hàng mới
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, Customer_ID.getText());
                prepare.setString(2, Customer_Name.getText());
                prepare.setString(3, Customer_CCCD.getText());
                prepare.setDate(4, java.sql.Date.valueOf(Customer_Day.getValue()));
                prepare.setDate(5, java.sql.Date.valueOf(Customer_Dob.getValue()));
                prepare.setString(6, Customer_Add.getText());
                prepare.setString(7, Customer_sdt.getText());
                prepare.setString(8, Customer_Dp.getSelectionModel().getSelectedItem());
                prepare.setString(9, Customer_gt.getSelectionModel().getSelectedItem());

                prepare.executeUpdate();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Thêm Khách Hàng Thành Công!");
                alert.showAndWait();

                // Cập nhật danh sách khách hàng và đặt lại biểu mẫu
                CustomerShowListData();
                CustomerReset();
            }
        }

    } catch (Exception e) {
        showErrorAlert("ERROR: ", e.getMessage());
    }
}

    public void CustomerUpdate() {
         if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Chỉ có Giao Dịch Viên của trụ sở con mới có quyền Tạo Khách Hàng tương ứng với trụ sở đó!");
            alert.showAndWait();
            return;
    }
       

        String sql = "UPDATE Customer SET name = '"
                +  Customer_Name.getText() + "', CCCD = '"
                +  Customer_CCCD.getText() + "', Ngaycap = '"
                +  java.sql.Date.valueOf(Customer_Day.getValue()) + "', Dob = '"
                +  java.sql.Date.valueOf(Customer_Dob.getValue()) + "', adress = '"                
                +  Customer_Add.getText() + "', Sdt = '"                
                +  Customer_sdt.getText() + "', ID_Dp = '"
                +  Customer_Dp.getSelectionModel().getSelectedItem() + "', gender = '"
                +  Customer_gt.getSelectionModel().getSelectedItem() + 
                "' WHERE ID ='" + Customer_ID.getText() + "'";

        try {
            Alert alert;
              Connection connect = DatabaseConnectionManager.getConnection();

            if (Customer_ID.getText().isEmpty()
                    || Customer_Name.getText().isEmpty()
                    || Customer_CCCD.getText().isEmpty()
                    || Customer_Day.getValue()==null
                     || Customer_Dob.getValue()==null
                     || Customer_sdt.getText().isEmpty()
                     || Customer_gt.getSelectionModel().getSelectedItem() == null
                     || Customer_Add.getText().isEmpty()
                     || Customer_Dp.getSelectionModel().getSelectedItem() == null
                    
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin");
                alert.showAndWait();
            } else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Update thông tin thành công!");
                alert.showAndWait();

                CustomerShowListData();
            }

        } catch (Exception e) {
            showErrorAlert("ERROR: ", e.getMessage());
        }
    }
    public void CustomerReset() {
        Customer_ID.setText("");
        Customer_Name.setText("");
         Customer_CCCD.setText("");
         Customer_Day.setValue(null);
         Customer_Dob.setValue(null);
         Customer_Add.setText("");
         Customer_Dp.getSelectionModel().clearSelection();
         Customer_gt.getSelectionModel().clearSelection();
         Customer_sdt.setText("");
    }
    public ObservableList<Customer> CustomerListData() {
        ObservableList<Customer> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Customer";

        try {
             Connection connect = DatabaseConnectionManager.getConnection();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Customer kh ;

            while (result.next()) {
                kh = new Customer(result.getString("ID"),
                        result.getString("name"),
                        result.getString("CCCD"),
                        result.getDate("Ngaycap"),
                        result.getDate("Dob"),
                        result.getString("adress"),
                        result.getString("Sdt"),
                        result.getString("ID_Dp"),
                        result.getString("gender"));
                listData.add(kh);

            }

        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }

    private ObservableList<Customer> CustomerList;

    public void CustomerShowListData() {
        CustomerList = CustomerListData();

        Customer_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Customer_col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Customer_col_CCCD.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        Customer_col_Day.setCellValueFactory(new PropertyValueFactory<>("Ngaycap"));
        Customer_col_Dob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        Customer_col_Add.setCellValueFactory(new PropertyValueFactory<>("adress"));
        Customer_col_sdt.setCellValueFactory(new PropertyValueFactory<>("Sdt"));
        Customer_col_Dp.setCellValueFactory(new PropertyValueFactory<>("ID_Dp"));
        Customer_col_gt.setCellValueFactory(new PropertyValueFactory<>("gender"));
        
        Customer_tableView.setItems(CustomerList);

    }

    public void CustomerSelect() {

        Customer KH = Customer_tableView.getSelectionModel().getSelectedItem();
        int num = Customer_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        Customer_ID.setText(String.valueOf(KH.getID()));
        Customer_Name.setText(String.valueOf(KH.getName()));
         Customer_CCCD.setText(String.valueOf(KH.getCCCD()));
        Date day = KH.getNgaycap(); // Giả sử dobDate là một đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
       
         Customer_Day.setValue(LocalDate.parse( dateFormat.format(day)));
         Date dob = KH.getDob(); // Giả sử dobDate là một đối tượng Date
         SimpleDateFormat dobFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng
         Customer_Dob.setValue(LocalDate.parse(dobFormat.format(dob)));
         Customer_Add.setText(String.valueOf(KH.getAdress()));
         Customer_Dp.getSelectionModel().select((String)KH.getID_Dp());
         Customer_gt.getSelectionModel().select((String) KH.getGender());
          Customer_sdt.setText(String.valueOf(KH.getSdt()));

    }
     private String[] LoaiGDList = {"CHUYỂN TIỀN", "RÚT TIỀN"};
     public void CRList() {
        List<String> listP = new ArrayList<>();

        for (String data : LoaiGDList) {
            listP.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listP);
        CR_loai.setItems(listData);
    }


public void CRAdd() {
     if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Chỉ có Giao Dịch Viên ở trụ sở con mới có quyền thực hiện giao dịch !");
            alert.showAndWait();
            return;
    }
    Date date = new Date(); // Lấy thời điểm hiện tại
    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime()); // Chuyển đổi thành Timestamp để lưu vào cột datetime trong SQL

    String sqlInsert = "INSERT INTO TransactionCR "
            + "(ID_CR, STK, LoaiGD, Day, Money, ID_NV) "
            + "VALUES(?, ?, ?, ?, ?, ?)";
    
    String sqlUpdateBalance = "UPDATE Account SET Sodu = ? WHERE STK = ?";
    String sqlCheckBalance = "SELECT Sodu FROM Account WHERE STK = ?";
    String sqlCheckAccount = "SELECT STK FROM Account WHERE STK = ?";

    Connection connect = null;
    PreparedStatement prepare = null;
    ResultSet result = null;
   

    try {
        connect = DatabaseConnectionManager.getConnection();

        if (CR_id.getText().isEmpty()
                || CR_stk.getText().isEmpty()
                || CR_loai.getSelectionModel().getSelectedItem() == null
                || CR_money.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
            return;
        }
        else{
            String check = "SELECT ID_CR FROM TransactionCR WHERE ID_CR = '"
                        + CR_id.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);
      
     
        
            if (result.next()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Mã Chuyển/Rút " + CR_id.getText() + " đã tồn tại !");
                alert.showAndWait();
                return;
            } 

        String stk = CR_stk.getText();
        BigDecimal money = new BigDecimal(CR_money.getText());

        // Kiểm tra sự tồn tại của STK
        prepare = connect.prepareStatement(sqlCheckAccount);
        prepare.setString(1, stk);
        result = prepare.executeQuery();
        
        if (!result.next()) {
            Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Error Message");
             alert.setHeaderText(null);
             alert.setContentText("STK: " + stk + " không tồn tại ở server này!");
             alert.showAndWait();
            return;
        }

        // Begin transaction
        connect.setAutoCommit(false);

        // Insert transaction record
        prepare = connect.prepareStatement(sqlInsert);
        prepare.setString(1, CR_id.getText());
        prepare.setString(2, stk);
        prepare.setString(3, (String) CR_loai.getSelectionModel().getSelectedItem());
        prepare.setTimestamp(4, sqlTimestamp); // Sử dụng timestamp để lưu thời điểm hiện tại vào cột datetime
        prepare.setString(5, CR_money.getText());
        prepare.setString(6, getData.username);
        prepare.executeUpdate();

        // Update account balance based on transaction type
        String transactionType = (String) CR_loai.getSelectionModel().getSelectedItem();
        BigDecimal transactionAmount = new BigDecimal(CR_money.getText());
        prepare = connect.prepareStatement(sqlCheckBalance);
        prepare.setString(1, stk);
        result = prepare.executeQuery();
        if (result.next()) {
            BigDecimal currentBalance = new BigDecimal(result.getString("Sodu"));
            BigDecimal newBalance = currentBalance;
            if (transactionType.equalsIgnoreCase("CHUYỂN TIỀN")) {
                newBalance = currentBalance.add(transactionAmount);
            } else if (transactionType.equalsIgnoreCase("RÚT TIỀN")) {
                if (currentBalance.compareTo(transactionAmount) >= 0) {
                    newBalance = currentBalance.subtract(transactionAmount);
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài khoản không đủ để rút tiền!");
                    alert.showAndWait();
                    connect.rollback();
                    connect.setAutoCommit(true); // Reset autocommit mode
                    return; // Exit the method without committing
                }
            }
            prepare = connect.prepareStatement(sqlUpdateBalance);
            prepare.setString(1, newBalance.toPlainString());
            prepare.setString(2, stk);
            prepare.executeUpdate();
        }

        // Commit transaction
        connect.commit();

       Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Thực hiện Chuyển/Rút thành công!");
        alert.showAndWait();

        // Thực hiện các thao tác khác như cập nhật danh sách, đặt lại form...
        CRShowListData();
        CRReset();
        }

    } catch (Exception e) {
        try {
            if (connect != null) {
                connect.rollback(); // Rollback transaction if error occurs
                connect.setAutoCommit(true); // Reset autocommit mode
            }
        } catch (Exception rollbackEx) {
            rollbackEx.printStackTrace();
        }
        showErrorAlert("ERROR: ", e.getMessage());
    } finally {
        try {
            if (result != null) result.close();
            if (prepare != null) prepare.close();
            if (connect != null) {
                connect.setAutoCommit(true); // Reset autocommit mode in case it wasn't reset during exception handling
            }
        } catch (Exception finalEx) {
            finalEx.printStackTrace();
        }
    }
}



     public ObservableList<TransactionCR> CRListData() {

        ObservableList<TransactionCR> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM TransactionCR";

    

        try {
                Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            TransactionCR CR;

            while (result.next()) {
                CR = new TransactionCR(result.getString("ID_CR"),
                        result.getString("STK"),
                        result.getString("LoaiGD"),
                        result.getDate("Day"),
                        result.getString("Money"),
                        result.getString("ID_NV"));
                listData.add(CR);
            }
        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }
    private ObservableList<TransactionCR> CRList;

    public void CRShowListData() {
        CRList = CRListData();

        CR_col_id.setCellValueFactory(new PropertyValueFactory<>("ID_CR"));
        CR_col_stk.setCellValueFactory(new PropertyValueFactory<>("STK"));
        CR_col_loai.setCellValueFactory(new PropertyValueFactory<>("LoaiGD"));
        CR_col_day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        CR_col_money.setCellValueFactory(new PropertyValueFactory<>("Money"));
        CR_col_nv.setCellValueFactory(new PropertyValueFactory<>("ID_NV"));
        
        CR_tableView.setItems(CRList);

    }

    public void CRSelect() {
        TransactionCR CR = CR_tableView.getSelectionModel().getSelectedItem();
        int num = CR_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        CR_id.setText(String.valueOf(CR.getID_CR()));
        CR_stk.setText(CR.getSTK());
        CR_loai.getSelectionModel().select((String) CR.getLoaiGD());
        CR_money.setText(CR.getMoney());
    }


    public void CRReset() {
    CR_id.setText("");
    CR_stk.setText("");
    CR_loai.getSelectionModel().clearSelection();
    CR_money.setText("");
    
       }
public void CRSearch() {
    // Giả sử CRList là ObservableList chứa các đối tượng TransactionCR
    FilteredList<TransactionCR> filteredList = new FilteredList<>(CRList, e -> true);

    CR_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(transactionData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (transactionData.getID_CR().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getSTK().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getLoaiGD().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getDay().toString().contains(searchKey)) {
                return true;
            } else if (transactionData.getMoney().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getID_NV().toLowerCase().contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<TransactionCR> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(CR_tableView.comparatorProperty());
    CR_tableView.setItems(sortedList);
}
 
    
public void GDAdd() {
     if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Chỉ có Giao Dịch Viên ở trụ sở con mới có quyền thực hiện giao dịch !");
            alert.showAndWait();
            return;
    }
    Date date = new Date(); // Lấy thời điểm hiện tại
    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime()); // Chuyển đổi thành Timestamp để lưu vào cột datetime trong SQL

    try {
        Alert alert;
        Connection connect = DatabaseConnectionManager.getConnection();

        if (GD_id.getText().isEmpty()
                || GD_stk1.getText().isEmpty()
                || GD_stk2.getText().isEmpty()
                || GD_money.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
            return;
        }

        String idHd = GD_id.getText();
        String stk1 = GD_stk1.getText();
        String stk2 = GD_stk2.getText();
        String money = GD_money.getText();
        String idNv = getData.username;

        // Gọi stored procedure
        String sql = "{call TransferMoneytong(?, ?, ?, ?, ?)}";
// ĐOẠN NÀY CÓ THỂ DÙNG String sql = "{call TransferMoney(?, ?, ?, ?, ?)}"; ĐỂ LINK SERVER ĐẾN CÁC MÁY
        CallableStatement cstmt = connect.prepareCall(sql);
        cstmt.setString(1, idHd);
        cstmt.setString(2, stk1);
        cstmt.setString(3, stk2);
        cstmt.setString(4, money);
        cstmt.setString(5, idNv);

        cstmt.execute();

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Thực hiện giao dịch chuyển tiền thành công!");
        alert.showAndWait();

        // Thực hiện các thao tác khác như cập nhật danh sách, đặt lại form...
        GDShowListData();
        GDReset();

    } catch (SQLException e) {
        showErrorAlert("ERROR:test: ", e.getMessage());
    }
}

//public void GDAdd() {
//     if (getData.id.equals("TSHN") || getData.chucvu.equals("Quản Trị Viên")) {
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setTitle("Error Message");
//            alert.setHeaderText(null);
//            alert.setContentText("Chỉ có Giao Dịch Viên ở trụ sở con mới có quyền thực hiện giao dịch !");
//            alert.showAndWait();
//            return;
//    }
//    Date date = new Date(); // Lấy thời điểm hiện tại
//    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(date.getTime()); // Chuyển đổi thành Timestamp để lưu vào cột datetime trong SQL
//
//    String sqlInsert = "SET XACT_ABORT ON ; INSERT INTO TransactionGD "
//            + "(ID_HD, STK1, STK2, Money, Day, ID_Nv) "
//            + "VALUES(?, ?, ?, ?, ?, ?)";
//    String sqlUpdateAccount1 = "SET XACT_ABORT ON; UPDATE Account SET Sodu = ? WHERE STK = ?";
//    String sqlUpdateAccount2Local = "SET XACT_ABORT ON; UPDATE Account SET Sodu = ? WHERE STK = ?";
//    String sqlUpdateAccount2Linked = "SET XACT_ABORT ON;UPDATE [LINK_SERVER_TO_TRONG].[QLNH].[DBO].Account SET Sodu = ? WHERE STK = ?";
//
//    Connection connect = null;
//    PreparedStatement prepare = null;
//    ResultSet resultSet = null;
//    Alert alert;
//
//    try {
//        connect = DatabaseConnectionManager.getConnection();
//
//        if (GD_id.getText().isEmpty()
//                || GD_stk1.getText().isEmpty()
//                || GD_stk2.getText().isEmpty()
//                || GD_money.getText().isEmpty()) {
//            alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Message");
//            alert.setHeaderText(null);
//            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
//            alert.showAndWait();
//            return;
//        }
//         else{
//            String check = "SELECT ID_HD FROM TransactionGD WHERE ID_HD = '"
//                        + GD_id.getText() + "'";
//
//                statement = connect.createStatement();
//                result = statement.executeQuery(check);
//      
//     
//        
//            if (result.next()) {
//                alert = new Alert(AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Mã Giao Dịch " + GD_id.getText() + " đã tồn tại !");
//                alert.showAndWait();
//                return;
//            } 
//
//        String stk1 = GD_stk1.getText();
//        String stk2 = GD_stk2.getText();
//        BigDecimal money = new BigDecimal(GD_money.getText());
//
//        // Kiểm tra sự tồn tại của tài khoản
//        String checkAccount = "SELECT Sodu FROM Account WHERE STK = ?";
//        PreparedStatement checkStmt = connect.prepareStatement(checkAccount);
//        checkStmt.setString(1, stk1);
//        resultSet = checkStmt.executeQuery();
//
//        if (!resultSet.next()) {
//            alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Message");
//            alert.setHeaderText(null);
//            alert.setContentText("Tài khoản " + stk1 + " không tồn tại!");
//            alert.showAndWait();
//            return;
//        }
//
//        BigDecimal balance1 = new BigDecimal(resultSet.getString("Sodu"));
//
//        checkStmt.setString(1, stk2);
//        resultSet = checkStmt.executeQuery();
//
//        boolean isLocalAccount = resultSet.next();
//        BigDecimal balance2;
//        if (!isLocalAccount) {
//            try {
//                String checkAccountLinked = "SELECT Sodu FROM [LINK_SERVER_TO_TRONG].[QLNH].[DBO].Account WHERE STK = ?";
//                PreparedStatement checkStmtLinked = connect.prepareStatement(checkAccountLinked);
//                checkStmtLinked.setString(1, stk2);
//                ResultSet rsLinked = checkStmtLinked.executeQuery();
//
//                if (!rsLinked.next()) {
//                    alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error Message");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Tài khoản " + stk2 + " không tồn tại trong toàn hệ thống!");
//                    alert.showAndWait();
//                    return;
//                }
//                balance2 = new BigDecimal(rsLinked.getString("Sodu"));
//                rsLinked.close();
//                checkStmtLinked.close();
//            } catch (SQLException ex) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Error Message");
//                alert.setHeaderText(null);
//                alert.setContentText("Máy chủ không hoạt động hoặc đang bảo trì!");
//                alert.showAndWait();
//                return;
//            }
//        } else {
//            balance2 = new BigDecimal(resultSet.getString("Sodu"));
//        }
//
//        // Kiểm tra số dư tài khoản
//        if (balance1.compareTo(money) < 0) {
//            alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Message");
//            alert.setHeaderText(null);
//            alert.setContentText("Số dư tài khoản " + stk1 + " không đủ để thực hiện giao dịch!");
//            alert.showAndWait();
//            return;
//        }
//
//        // Thực hiện giao dịch
//        connect.setAutoCommit(false); // Bắt đầu transaction
//
//        // Thêm vào bảng TransactionGD
//        prepare = connect.prepareStatement(sqlInsert);
//        prepare.setString(1, GD_id.getText());
//        prepare.setString(2, stk1);
//        prepare.setString(3, stk2);
//        prepare.setString(4, GD_money.getText());
//        prepare.setTimestamp(5, sqlTimestamp); // Sử dụng timestamp để lưu thời điểm hiện tại vào cột datetime
//        prepare.setString(6, getData.username);
//        prepare.executeUpdate();
//
//        // Cập nhật số dư tài khoản 1 (trừ tiền)
//        PreparedStatement updateStmt1 = connect.prepareStatement(sqlUpdateAccount1);
//        updateStmt1.setString(1, balance1.subtract(money).toPlainString());
//        updateStmt1.setString(2, stk1);
//        updateStmt1.executeUpdate();
//
//        // Cập nhật số dư tài khoản 2 (cộng tiền)
//        PreparedStatement updateStmt2;
//        if (isLocalAccount) {
//            updateStmt2 = connect.prepareStatement(sqlUpdateAccount2Local);
//        } else {
//            updateStmt2 = connect.prepareStatement(sqlUpdateAccount2Linked);
//        }
//        updateStmt2.setString(1, balance2.add(money).toPlainString());
//        updateStmt2.setString(2, stk2);
//        updateStmt2.executeUpdate();
//
//        connect.commit(); // Commit transaction
//
//        alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Message");
//        alert.setHeaderText(null);
//        alert.setContentText("Thực hiện giao dịch chuyển tiền thành công!");
//        alert.showAndWait();
//
//        // Thực hiện các thao tác khác như cập nhật danh sách, đặt lại form...
//        GDShowListData();
//        GDReset();
//        }
//
//    } catch (Exception e) {
//        try {
//            if (connect != null) {
//                connect.rollback(); // Rollback transaction nếu có lỗi
//            }
//        } catch (Exception rollbackException) {
//            showErrorAlert("ERROR: ", rollbackException.getMessage());
//        }
//        showErrorAlert("ERROR: ", e.getMessage());
//    } finally {
//        try {
//            if (resultSet != null) resultSet.close();
//            if (prepare != null) prepare.close();
//            if (connect != null) {
//                connect.setAutoCommit(true); // Reset autocommit mode
//            }
//        } catch (Exception finalEx) {
//            finalEx.printStackTrace();
//        }
//    }
//}




     public ObservableList<TransactionGD> GDListData() {

        ObservableList<TransactionGD> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM TransactionGD";

    

        try {
                Connection connect = DatabaseConnectionManager.getConnection();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            TransactionGD GD;

            while (result.next()) {
                GD = new TransactionGD(result.getString("ID_HD"),
                        result.getString("STK1"),
                        result.getString("STK2"),
                        result.getString("Money"),
                        result.getDate("Day"),
                        result.getString("ID_Nv"));
                listData.add(GD);
            }
        } catch (Exception e) {
             showErrorAlert("ERROR: ", e.getMessage());
        }
        return listData;
    }
    private ObservableList<TransactionGD> GDList;

    public void GDShowListData() {
        GDList = GDListData();

        GD_col_id.setCellValueFactory(new PropertyValueFactory<>("ID_HD"));
        GD_col_stk1.setCellValueFactory(new PropertyValueFactory<>("STK1"));
        GD_col_stk2.setCellValueFactory(new PropertyValueFactory<>("STK2"));
        GD_col_money.setCellValueFactory(new PropertyValueFactory<>("Money"));
        GD_col_day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        GD_col_nv.setCellValueFactory(new PropertyValueFactory<>("ID_Nv"));
        
        GD_tableView.setItems(GDList);

    }

    public void GDSelect() {
        TransactionGD GD = GD_tableView.getSelectionModel().getSelectedItem();
        int num = GD_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        GD_id.setText(String.valueOf(GD.getID_HD()));
        GD_stk1.setText(GD.getSTK1());
        GD_stk2.setText(GD.getSTK2());
        GD_money.setText(GD.getMoney());
    }


    public void GDReset() {
    GD_id.setText("");
    GD_stk1.setText("");
    GD_stk2.setText("");
    GD_money.setText("");
    
       }
public void GDSearch() {
    // Giả sử GDList là ObservableList chứa các đối tượng TransactionGD
    FilteredList<TransactionGD> filteredList = new FilteredList<>(GDList, e -> true);

    GD_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(transactionData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (transactionData.getID_HD().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getSTK1().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getSTK2().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getMoney().toLowerCase().contains(searchKey)) {
                return true;
            } else if (transactionData.getDay().toString().contains(searchKey)) {
                return true;
            } else if (transactionData.getID_Nv().toLowerCase().contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<TransactionGD> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(GD_tableView.comparatorProperty());
    GD_tableView.setItems(sortedList);
}
    public void defaultNav() {
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

    public void displayUsername() {
        username.setText(getData.username);
        name.setText(getData.name);
        Chucvu.setText(getData.chucvu);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);
            

            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            dp_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");

            homeTotalNV();
            homeTotalKH();
            homeTotalTK();
            homeTotalCard();
            homeChart();

        } else if (event.getSource() == dp_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(true);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);
            

            dp_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");
            DPShowListData();
           
        

        }else if (event.getSource() == Staff_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(true);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);
            

            Staff_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_btn.setStyle("-fx-background-color:transparent");
            dp_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");
            StaffShowListData();
            StaffGendernList();
            StaffPositionList();
            StaffDpList();
            StaffSearch();

        } else if (event.getSource() == Account_btn) {
            home_form.setVisible(false);
              DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(true);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);

            Account_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
             dp_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");
            

            AccountShowListData();
            AccountDpList();

        }else if (event.getSource() == Customer_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(true);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);
            

            Customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
             dp_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");
            CustomerShowListData();
            CustomerGendernList();
            CustomerDpList();
        }else if (event.getSource() == CR_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(true);
            GD_form.setVisible(false);
             CardType_form.setVisible(false);
            Card_form.setVisible(false);
            
            CR_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
             dp_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            GD_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");

            CRShowListData();
            CRList();

        }else if (event.getSource() == GD_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(true);
            CardType_form.setVisible(false);
            Card_form.setVisible(false);
            
            GD_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
             dp_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:transparent");

            GDShowListData();
           

        }else if (event.getSource() == CardType_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
            CardType_form.setVisible(true);
            Card_form.setVisible(false);
            
            GD_btn.setStyle("-fx-background-color:transparent");
             dp_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            Card_btn.setStyle("-fx-background-color:transparent");

            CardTypeShowListData();
           

        }else if (event.getSource() == Card_btn) {
            home_form.setVisible(false);
             DP_form.setVisible(false);
            Staff_form.setVisible(false);
            Account_form.setVisible(false);
            Customer_form.setVisible(false);
            CR_form.setVisible(false);
            GD_form.setVisible(false);
            CardType_form.setVisible(false);
            Card_form.setVisible(true);
            
            GD_btn.setStyle("-fx-background-color:transparent");
            dp_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");
            Staff_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            Account_btn.setStyle("-fx-background-color:transparent");
            CR_btn.setStyle("-fx-background-color:transparent");
            CardType_btn.setStyle("-fx-background-color:transparent");
            Card_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");

            CardShowListData();
            CTypeList();
           

        }

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Bạn có muốn rời khỏi hệ thống?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        defaultNav();

        homeTotalNV();
        homeTotalKH();
        homeTotalTK();
        homeTotalCard();
        homeChart();
        
        DPShowListData();
     
        StaffShowListData();
        StaffGendernList();
        StaffPositionList();
        StaffDpList();

        AccountShowListData();
        AccountDpList();
        
        CustomerShowListData();
        CustomerGendernList();
        CustomerDpList();
        
        CRShowListData();
        CRList();
        
        GDShowListData();
        
        
        CardTypeShowListData();
        CardShowListData();
        CTypeList();
       
    }

   private void showErrorAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

  

}
