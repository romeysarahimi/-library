package repository;

import entity.Member;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberRepository implements MemberRepository {


    @Override
    public void save(Member member) {
        String insertQuery = "INSERT INTO tb_member (username, tel, address, email) VALUES (?,?,?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(insertQuery)) {

            pS.setString(1, member.getUsername());
            pS.setString(2, member.getTel());
            pS.setString(3, member.getAddress());
            pS.setString(4, member.getEmail());
            pS.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Member findById(int id) {
        String findQuery = "SELECT id, username, tel, address, email FROM tb_member WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement pS = connection.prepareStatement(findQuery);

            pS.setInt(1, id);

            ResultSet rs = pS.executeQuery();

            if (rs.next()) {
                int memberId = rs.getInt("id");
                String username = rs.getString("username");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String email = rs.getString("email");
                return new Member(memberId, username, tel, address, email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Member findByUsername(String username) {

        String findQuery = "SELECT id, username, tel, address, email FROM tb_member WHERE username = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement pS = connection.prepareStatement(findQuery);

            pS.setString(1, username);

            ResultSet rs = pS.executeQuery();

            if (rs.next()) {
                int memberId = rs.getInt("id");
                String usernameMember = rs.getString("username");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String email = rs.getString("email");
                return new Member(memberId, username, tel, address, email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Member member) {
        String updateQuery = "UPDATE tb_member SET username = ?, tel = ?, address = ?, email = ? WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(updateQuery)) {

            pS.setString(1, member.getUsername());
            pS.setString(2, member.getTel());
            pS.setString(3, member.getAddress());
            pS.setString(4, member.getEmail());
            pS.setInt(5, member.getId());

            pS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        String findQuery = "SELECT id, username, tel, address, email FROM tb_member";

        try (Connection connection = ConnectionUtil.getConnection();
             Statement pS = connection.createStatement()) {

            ResultSet rs = pS.executeQuery(findQuery);
            var members = new ArrayList<Member>();
            while (rs.next()) {
                int memberId = rs.getInt("id");
                String username = rs.getString("username");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                String email = rs.getString("email");
                members.add(new Member(memberId, username, tel, address, email));
            }

            return members;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Member member) {
        String deleteQuery = "DELETE FROM tb_member WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(deleteQuery)) {

            pS.setInt(1, member.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count() {
        String countQuery = "SELECT COUNT(*) AS count FROM member";

        try (Connection connection = ConnectionUtil.getConnection();
             Statement pS = connection.createStatement()) {

            ResultSet rs = pS.executeQuery(countQuery);
            if (rs.next()) {
                return rs.getInt("count");
            }

            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

