package tsdisc.com.br.tsdisc.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tsdisc.com.br.tsdisc.domain.Disco;
import tsdisc.com.br.tsdisc.repository.DiscoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DiscoService implements DiscoRepository {
    private static List<Disco> discos;

    static {
        discos = new ArrayList<>(
           List.of(new Disco(1, "Midnights", 8.5),
                   new Disco(2, "The Tortured Poets Department", 7.6),
                   new Disco(3, "Folklore", 8.8),
                   new Disco(4, "1989", 9.0)));
    }

    public List<Disco> listAll(){
        return discos;
    }
    public Disco findById(long id){
        return discos.stream()
                .filter(disco -> disco.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Disco ID not found"));
    }

    public Disco save(Disco disco){
        disco.setId(ThreadLocalRandom.current().nextLong(3,100000));
        discos.add(disco);
        return disco;
    }

    public void delete(long id) {discos.remove(findById(id));}

    public void replace(Disco disco){
        delete(disco.getId());
        discos.add(disco);
    }

}
