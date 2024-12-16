package com.marcos.gestao_de_frota.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class VeiculoMotoristaPK {

    @Column(name = "motorista_id")
    private Long motoristaId;

    @Column(name = "veiculo_id")
    private Long veiculoId;

    public VeiculoMotoristaPK() {
    }

    public VeiculoMotoristaPK(Long motoristaId, Long veiculoId) {
        this.motoristaId = motoristaId;
        this.veiculoId = veiculoId;
    }

    public Long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Long motoristaId) {
        this.motoristaId = motoristaId;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VeiculoMotoristaPK that = (VeiculoMotoristaPK) object;
        return Objects.equals(motoristaId, that.motoristaId) && Objects.equals(veiculoId, that.veiculoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motoristaId, veiculoId);
    }
}
