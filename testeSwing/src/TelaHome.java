import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaHome extends JFrame{
    ArrayList<Avaliacao> BD = new ArrayList<>();
    ArrayList<Avaliacao> filtro = new ArrayList<>();

    public JPanel painelPrincipal;
    private JButton btGuardar;
    private JTextArea txtSaida;
    private JButton btBuscarEstabelecimento;
    private JTextField txtItens;
    private JTextField txtComentario;
    private JTextField txtEstabelecimento;
    private JTextField txtNota;
    private JButton btBuscarItem;
    private JButton fakeButton;
    private JButton btMostrarTudo;

    private void limparInputs(){
        txtEstabelecimento.setText("");
        txtItens.setText("");
        txtNota.setText("");
        txtComentario.setText("");
        txtEstabelecimento.grabFocus();
    }

    private void mostrarFiltro(){
        String s = "";
        for (Avaliacao a : filtro){
            s += "\n=====================\n";
            s += a.getEstabelecimento() + "\n";
            s += a.getItens() + "\n";
            s += a.getNota() + "\n";
            s += a.getComentario() + "\n";
        }
        txtSaida.setText(s);
    }

    private void mostrarTodos(){
        filtro.clear();
        for (Avaliacao a : BD){
            filtro.add(a);
        }
        mostrarFiltro();
    }

    public TelaHome() {
    btGuardar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
        btGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estabelecimento = txtEstabelecimento.getText();
                String itens = txtItens.getText();
                int nota = Integer.parseInt(txtNota.getText());
                String comentario = txtComentario.getText();

                BD.add(new Avaliacao(estabelecimento, itens, nota, comentario));
                limparInputs();

                System.out.println(BD);
            }
        });
        btBuscarEstabelecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtro.clear();
                String est = txtEstabelecimento.getText();
                for (Avaliacao a : BD){
                    if(a.getEstabelecimento().toLowerCase().contains(est.toLowerCase())){
                        filtro.add(a);
                    }
                }
                mostrarFiltro();
            }
        });
        btBuscarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtro.clear();
                String item = txtItens.getText();
                for (Avaliacao a : BD){
                    if(a.getItens().toLowerCase().contains(item.toLowerCase())){
                        filtro.add(a);
                    }
                }
                mostrarFiltro();
            }
        });
        fakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Avaliacao a = new Avaliacao("Pizzaria Um", "Pizza de queijo com orégano", 7, "Seria muito bom se fosse melhor");
                BD.add(a);

                a = new Avaliacao("Pizzaria Duo", "Pizza de misto quente", 9, "Melhor que pão na chapa");
                BD.add(a);

                a = new Avaliacao("Lancheria dos lanches", "X-bacon", 9, "Muito gostosinho");
                BD.add(a);

                a = new Avaliacao("Pastelaria Casa de pastel", "Pastel de carne", 4, "Faltou carne");
                BD.add(a);

                a = new Avaliacao("Marmitaria gourmet", "Marmita executiva", 8, "Muito arroz, mas gostosa");
                BD.add(a);

                a = new Avaliacao("Congelados da Elza", "Marmita de escondidinho", 10, "Não tem como fazer um escondidinho ruim.");
                BD.add(a);

                a = new Avaliacao("Batataria do Batata", "Suco de batata frita", 10, "Hummm, nhami, nhami...");
                BD.add(a);

                mostrarTodos();
            }
        });

        btMostrarTudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });
    }
}
