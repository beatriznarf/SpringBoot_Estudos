package bsd.services;

import bsd.dtos.organizacaoDto;
import bsd.models.organizacaoModel;
import org.modelmapper.ModelMapper;
import bsd.dtos.organizacaoCreateRequest;
import bsd.repositories.organizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class organizacaoService {

    private organizacaoRepository organizacaoRepository;
    private ModelMapper modelMapper;

    public organizacaoService(organizacaoRepository organizacaoRepository,
                              ModelMapper modelMapper) {
        this.organizacaoRepository = organizacaoRepository;
        this.modelMapper = modelMapper;
    }


    public void delete(Long id) {
        organizacaoRepository.deleteById(id);
    }


    public List<organizacaoDto> findAll() {
        List<organizacaoModel> organizacoes = organizacaoRepository.findAll();
        return organizacoes.stream().map(organizacao -> {


            organizacaoDto organizacaoDto = new organizacaoDto();
            organizacaoDto.setId(organizacao.getId());
            organizacaoDto.setNome(organizacao.getNome());
            organizacaoDto.setSigla(organizacao.getSigla());
            organizacaoDto.setChefe(organizacao.getChefe());
            organizacaoDto.setMembros(organizacao.getMembros());


            return organizacaoDto;
        }).collect(Collectors.toList());
    }


    public organizacaoDto update(Long id, organizacaoDto organizacaoDetails) {
        Optional<organizacaoModel> optionalorganizacao = organizacaoRepository.findById(id);

        if (optionalorganizacao.isPresent()) {
            organizacaoModel organizacaoModel = optionalorganizacao.get();

            organizacaoModel.setNome(organizacaoDetails.getNome());
            organizacaoModel.setSigla(organizacaoDetails.getSigla());
            organizacaoModel.setChefe(organizacaoDetails.getChefe());
            organizacaoModel.setMembros(organizacaoDetails.getMembros());


            organizacaoModel updatedorganizacao = organizacaoRepository.save(organizacaoModel);

            organizacaoDto organizacaoDto = new organizacaoDto();
            organizacaoDto.setId(updatedorganizacao.getId());
            organizacaoDto.setNome(updatedorganizacao.getNome());
            organizacaoDto.setSigla(updatedorganizacao.getSigla());
            organizacaoDto.setChefe(updatedorganizacao.getChefe());
            organizacaoDto.setMembros(updatedorganizacao.getMembros());

            return organizacaoDto;
        } else {
            return null;
        }
    }

        public organizacaoDto save (organizacaoCreateRequest organizacaoRequest){
            organizacaoModel organizacaoModel = modelMapper.map(organizacaoRequest, organizacaoModel.class);
            organizacaoModel savedorganizacao = organizacaoRepository.save(organizacaoModel);
            organizacaoDto organizacaoDto = modelMapper.map(savedorganizacao, organizacaoDto.class);
            return organizacaoDto;

        }

        public organizacaoDto findById(Long id){
            Optional<organizacaoModel> optionalorganizacao = organizacaoRepository.findById(id);
            if (optionalorganizacao.isPresent()) {
                organizacaoModel organizacaoModel = optionalorganizacao.get();
                organizacaoDto organizacaoDto = new organizacaoDto();

                organizacaoDto.setId(organizacaoModel.getId());
                organizacaoDto.setNome(organizacaoModel.getNome());
                organizacaoDto.setSigla(organizacaoModel.getSigla());
                organizacaoDto.setChefe(organizacaoModel.getChefe());
                organizacaoDto.setMembros(organizacaoModel.getMembros());


                return organizacaoDto;
            } else {
                return null;
            }
        }
}
