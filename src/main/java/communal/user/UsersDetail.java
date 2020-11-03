package communal.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDetail {

    private long accountId;

    private String loginName;

    private String nickName;

    private String token;

    private String identity;

    private List<String> permissionList;
}
