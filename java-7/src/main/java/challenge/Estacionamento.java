package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    public List<Carro> vagas = new ArrayList<>();
    public int NUM_VAGAS = 10;

    public void estacionar(Carro carro) {

        verificarEstacionamento(carro);

        if(this.vagas.size() == NUM_VAGAS){
            verificarEstacionamentoCheio(carro);
        }else{
            this.vagas.add(carro);
        }
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.stream().anyMatch((carro1) -> carro1.equals(carro));
    }

    public void verificarEstacionamento(Carro carro){
        if (carro.getMotorista() == null)
            throw new EstacionamentoException("O carro deve ter motorista.");
        if(carro.getMotorista().getIdade() < 18)
            throw new EstacionamentoException("Motorista menor de idade.");
        if(carro.getMotorista().getPontos() > 20)
            throw new EstacionamentoException("Habilitação suspensa.");
    }

    private void verificarEstacionamentoCheio(Carro carro) {
        for(int posicao = 0; posicao < NUM_VAGAS; posicao++){
            if(this.vagas.get(posicao).getMotorista().getIdade() <= 55){
                this.vagas.set(posicao, carro);
                break;
            }
            if(posicao == this.NUM_VAGAS - 1){
                throw new EstacionamentoException("Não há vagas.");
            }
        }
    }
}
