package duong.demo.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

  private String userId;
  private String username;
}
