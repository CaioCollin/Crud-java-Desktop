package DAO;

import DTO.jogosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class jogosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<jogosDTO> lista = new ArrayList<>();

    public void cadastrarFuncionario(jogosDTO objjogosDTO) {
        String sql = "insert into jogos (nome_jogo) values (?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objjogosDTO.getNome_jogo());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "jogosDAO" + e);
        }
    }

    public ArrayList<jogosDTO> pesquisarJogos() {

        String sql = "select * from jogos ";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                jogosDTO objjogosDTO = new jogosDTO();
                objjogosDTO.setId_jogo(rs.getInt("id_jogo"));
                objjogosDTO.setNome_jogo(rs.getString("nome_jogo"));

                lista.add(objjogosDTO);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PesquisarJogosDAO" + e);
        }

        return lista;
    }

    public void AlterarJogos(jogosDTO objjogosDTO) {
        String sql = "update jogos set nome_jogo = ?  where id_jogo = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objjogosDTO.getNome_jogo());
            pstm.setInt(2, objjogosDTO.getId_jogo());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "AlterarJogosDAO JogosDAO" + e);
        }
    }

    public void ExcluirFuncionario(jogosDTO objjogosDTO) {
        String sql = "delete from jogos where id_jogo = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objjogosDTO.getId_jogo());

            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Excluido!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ExcluirDAO JogosDAO" + e);
        }

    }

}
