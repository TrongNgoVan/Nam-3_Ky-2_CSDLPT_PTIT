/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage.bank.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Button close;
    
//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
//    
    private double x = 0;
    private double y = 0;
    public void loginAdmin(){
        
        String userID = username.getText();
        String sql = "SELECT * FROM Staff WHERE ID = ? and CCCD = ?";

        try {
            Db db = new Db();

            // Determine which connection to use based on the user ID prefix
            if (userID.startsWith("DN")) {
                connect = db.getConnection1();
                getData.name= "Ngân hàng NVT BANK trụ sở Đà Nẵng";
                getData.id="TSDN";
            } else if (userID.startsWith("CT")) {
                connect = db.getConnection2();
                getData.name= "Ngân hàng NVT BANK trụ sở Cần Thơ";
                getData.id = "TSCT";
            } else if (userID.startsWith("HCM")) {
                connect = db.getConnection3();
                getData.name= "Ngân hàng NVT BANK trụ sở TP.Hồ Chí Minh";
                getData.id= "TSHCM";
            } else {
                connect = db.getConnection();
                getData.name= "Ngân hàng NVT BANK trụ sở Tổng";
                getData.id="TSHN";
            }

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, userID);
            prepare.setString(2, password.getText());
            result = prepare.executeQuery();
            
            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng điền đầy đủ thông tin!");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    getData.username = username.getText();
                    getData.chucvu=result.getString("Chucvu");
                    getData.ten=result.getString("name");
                    // Save the connection for future use
                    DatabaseConnectionManager.setConnection(connect);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công");
                    alert.showAndWait();

                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sai username/ mật khẩu, lưu ý:"
                            + "\nUsername mặc định là mã nhân viên!"
                            + "\nMật khẩu mặc định là CCCD của nhân viên! ");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Server bạn muốn đăng nhập hiện không hoạt động hoặc đang bảo trì!");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    
    public void close(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

