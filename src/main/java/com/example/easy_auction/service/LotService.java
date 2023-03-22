package com.example.easy_auction.service;

import com.example.easy_auction.DTO.CreateLotDTO;
import com.example.easy_auction.DTO.FistAndLastLotBidDTO;
import com.example.easy_auction.DTO.FullDTO;
import com.example.easy_auction.DTO.LotDTO;
import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.model.projection.Projection;
import com.example.easy_auction.repositary.BidRepository;
import com.example.easy_auction.repositary.LotRepositary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class LotService {
    private final LotRepositary lotRepositary;
    private final BidRepository bidRepository;

    public LotService(LotRepositary lotRepositary, BidRepository bidRepository) {
        this.lotRepositary = lotRepositary;
        this.bidRepository = bidRepository;
    }

    public LotDTO getLotById(Integer id) {
        return LotDTO.fromLottoLotDTO(lotRepositary.findById(id).orElse(null));
    }

    public LotDTO createLotDTO(CreateLotDTO createLotDTO) {
        Lot lot = CreateLotDTO.fromCreateLotDTOtoLot(createLotDTO);
        lot.setStatus(LotStatus.CREATED);
        Lot sLot = lotRepositary.save(lot);
        return LotDTO.fromLottoLotDTO(sLot);
    }

    public Collection<LotDTO> getAllStatus(LotStatus status, Integer page) {
        PageRequest pageRequest = PageRequest.of((page - 1), 5);
        return lotRepositary.findAllByStatus(status, pageRequest).stream().map(LotDTO::fromLottoLotDTO).collect(Collectors.toList());
    }

    public Projection getInfoAboutFistBid(Integer id){
        return bidRepository.getInfoAboutFistBid(id);
    }

    public Projection getAvidGambler(Integer id) {
        return bidRepository.getAvidGambler(id);
    }

    private Integer sumCurrentPrice(Integer id, Integer bidPrice, Integer startPrice){
        return bidRepository.getBidCount(id) * bidPrice + startPrice;
    }

    public void LotStatusStart(Integer id) {
        Lot lotStart = lotRepositary.findById(id).get();
        lotStart.setStatus(LotStatus.STARTED);
        lotRepositary.save(lotStart);
    }

    public void LotStatusStopped(Integer id) {
        Lot lotStop = lotRepositary.findById(id).get();
        lotStop.setStatus(LotStatus.STOPPED);
        lotRepositary.save(lotStop);
    }

    private FistAndLastLotBidDTO getInfoOfLastBid(Integer id) {
        FistAndLastLotBidDTO fistAndLastLotBidDTO = new FistAndLastLotBidDTO();
        fistAndLastLotBidDTO.setBidDate(bidRepository.getInfoAboutFistBid(id).getBidDate());
        fistAndLastLotBidDTO.setName(bidRepository.getLastBid(id).getBidderName());
        return fistAndLastLotBidDTO;
    }

    public boolean chekLotCorrect(CreateLotDTO createLotDTO) {
        if (createLotDTO.getTitle() == null || createLotDTO.getTitle().isEmpty()) {
            return false;
        } else if (createLotDTO.getDescription() == null || createLotDTO.getDescription().isEmpty()) {
            return false;
        } else if (createLotDTO.getDescription() == null || createLotDTO.getBidPrice() == null) {
            return false;
        } else
        {
            return true;
        }
    }

    public FullDTO getInfoOnLot (Integer id) {
        FullDTO fullDTO = FullDTO.fromLotDTOtoFullDTO(getLotById(id));
        Integer curPrice = sumCurrentPrice(id, fullDTO.getBidPrice(), fullDTO.getStartPrice());
        fullDTO.setCurrentPrice(curPrice);
        fullDTO.setLastBid(getInfoOfLastBid(id));
        return fullDTO;
    }

    public Collection<FullDTO> getAllLotsTransfer() {
        return lotRepositary.findAll().stream().map(FullDTO::fromLottoFullDTO).
                peek(fullDTO -> fullDTO.setCurrentPrice(sumCurrentPrice(fullDTO.getId(), fullDTO.getBidPrice(), fullDTO.getStartPrice()))).peek(fullDTO -> fullDTO.setLastBid(getInfoOfLastBid(fullDTO.getId()))).
                collect(Collectors.toList());
    }

}
  // Девять методов. + ещё 1, + приватные.