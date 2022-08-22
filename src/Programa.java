import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    public static void main(String[] args) {

        List<Contato> listaContatos = new ArrayList<>();

        Contato contato1 = new Contato("Rafael","rafa@email.com","999123233");
        Contato contato2 = new Contato("Rafaela","rafinha@gmail.com","988133233");
        Contato contato3 = new Contato("Raff","raff@email.com","996123453");
        Contato contato4 = new Contato("Ralph","ralph@email.com","995123763");

        listaContatos.add(contato1);
        listaContatos.add(contato2);
        listaContatos.add(contato3);
        listaContatos.add(contato4);

        try{

            FileOutputStream fileOutputStream = new FileOutputStream("Lista de Contatos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(listaContatos);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Contato> listaContatosInput = null;

        try{

                FileInputStream fileInputStream = new FileInputStream("Lista de Contatos.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                listaContatosInput = (List<Contato>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
        } catch (IOException e) {
        throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
        }

        for (Contato contato: listaContatosInput) {
        System.out.println(contato.getNome() +" / "+ contato.getEmail()+" / "+ contato.getTelefone() );
        }

        }

}
