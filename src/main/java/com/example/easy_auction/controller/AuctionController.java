package com.example.easy_auction.controller;
import com.example.easy_auction.DTO.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.example.easy_auction.enumes.LotStatus;
import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.model.projection.Projection;
import com.example.easy_auction.service.BidService;
import com.example.easy_auction.service.LotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

@RequestMapping("lot")
@RestController
public class AuctionController {
    private final LotService lotService;

    private final BidService bidService;

    public AuctionController(LotService lotService, BidService bidService) {
        this.lotService = lotService;
        this.bidService = bidService;
    }

    @GetMapping("lot/{id}/fist")
    public ResponseEntity<Projection> getInfoAboutFistBid(@PathVariable Integer id) {
        if (lotService.getLotById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (lotService.getLotById(id).getStatus().equals(LotStatus.CREATED)) {
            return ResponseEntity.badRequest().build();
        }
        Projection projection = lotService.getInfoAboutFistBid(id);
        return ResponseEntity.ok(projection);
    }

    @GetMapping("lot/{id}/frequent")
    public ResponseEntity<Projection> getInfoAboutAvidGambler(@PathVariable Integer id) {
        if (lotService.getLotById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (lotService.getLotById(id).getStatus().equals(LotStatus.CREATED)) {
            return ResponseEntity.badRequest().build();
        }
        Projection projection = lotService.getAvidGambler(id);
        return ResponseEntity.ok(projection);

    }

    @GetMapping("lot/{id}")
    public ResponseEntity<FullDTO> getAllInfoAboutLot(@PathVariable Integer id) {
        if (lotService.getLotById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lotService.getInfoOnLot(id));
    }

    @PostMapping("lot/{id}/start")
    public ResponseEntity<Lot> startBidding(@PathVariable Integer id ) {
        LotDTO lotStarting = lotService.getLotById(id);
        if(lotStarting == null){
            return ResponseEntity.notFound().build();
        }
        if (lotStarting.getStatus().equals(LotStatus.STARTED)) {
            return ResponseEntity.ok().build();
        }
        if (lotStarting.getStatus().equals(LotStatus.CREATED)) {
            lotService.LotStatusStart(id);
        }
        if(lotStarting.getStatus().equals(LotStatus.STOPPED)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("lot/{id}/bid")
    public ResponseEntity<Bid> PlaceBidsOnLot(@PathVariable Integer id, @RequestBody BidDTO bidDTO) {
        LotDTO lotBid = lotService.getLotById(id);
        if (lotBid == null) {
            return ResponseEntity.notFound().build();
        }
        if(lotBid.getStatus().equals(LotStatus.CREATED) || lotBid.getStatus().equals(LotStatus.STOPPED)) {
            return ResponseEntity.badRequest().build();
        }
        bidDTO.setLot(id);
        bidService.createBid(bidDTO);
        return ResponseEntity.ok().build();
    }
    @PostMapping("lot/{id}/stop")
    public ResponseEntity<Lot> soppedBidding(@PathVariable Integer id) {
        LotDTO lotStopping = lotService.getLotById(id);
        if(lotStopping == null){
            return ResponseEntity.notFound().build();
        }
        if (lotStopping.getStatus().equals(LotStatus.STARTED)) {
            lotService.LotStatusSopped(id);
        }
        if(lotStopping.getStatus().equals(LotStatus.STOPPED)) {
            return ResponseEntity.ok().build();
        }
        if (lotStopping.getStatus().equals(LotStatus.CREATED)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("/lot")
    public ResponseEntity<LotDTO> createLot(@RequestBody CreateLotDTO createLotDTO){
        if(!lotService.chekLotCorrect(createLotDTO)) {
            return ResponseEntity.badRequest().build();
        }
        LotDTO lotCreate = lotService.createLotDTO(createLotDTO);
        return ResponseEntity.ok(lotCreate);
    }

    @GetMapping("lot/")
    public ResponseEntity<Collection<LotDTO>> getAllLots(@RequestParam LotStatus status,@RequestParam(required = false) Integer page) {
        if (page == null){
            page = 1;
        }
        return ResponseEntity.ok(lotService.getAllStatus(status, page));
    }



    @GetMapping("lot/export")
    public void downLoadSCVP (HttpServletResponse httpServletResponse) throws IOException {
        Collection<FullDTO> fullDTOS = lotService.getAllLotsTransfer();
        StringWriter stringWriter = new StringWriter();
        CSVPrinter scvPrinter = new  CSVPrinter(stringWriter, CSVFormat.DEFAULT);
        for(FullDTO fullDTO:fullDTOS){
            scvPrinter.printRecord(
                    fullDTO.getId(),
                    fullDTO.getTitle(),
                    fullDTO.getStatus(),
                    fullDTO.getLastBid() != null ? fullDTO.getLastBid().getName() : "",
                    fullDTO.getCurrentPrice());
        }
        scvPrinter.flush();
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename:\"lot.csv\"");
       PrintWriter printWriter = httpServletResponse.getWriter();
       printWriter.write(stringWriter.toString());
       printWriter.flush();
       printWriter.close();
    }

}
