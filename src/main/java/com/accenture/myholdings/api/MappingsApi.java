package com.accenture.myholdings.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.myholdings.dao.FundHoldingRepository;
import com.accenture.myholdings.dao.FundRepository;
import com.accenture.myholdings.dao.HoldingRepository;
import com.accenture.myholdings.dao.InvestorRepository;
import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.model.FundHoldingId;
import com.accenture.myholdings.model.FundHoldings;
import com.accenture.myholdings.model.FundHoldingsPK;
import com.accenture.myholdings.model.Holding;
import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.model.InvestorFunds;
import com.accenture.myholdings.service.FundHoldingService;
import com.accenture.myholdings.service.FundService;
import com.accenture.myholdings.service.HoldingService;
import com.accenture.myholdings.service.InvestorService;

import lombok.Data;

@RestController
public @Data class MappingsApi {

	@Autowired
	InvestorService investorServ;

	@Autowired
	FundService fundService;

	@Autowired
	HoldingService holdingService;

	@Autowired
	FundHoldingService fundHoldingService;

	@PostMapping("/addFundToInvestor")
	public Investor addFundToInvestor(@RequestBody InvestorFunds inFu) {
		Investor inv = investorServ.findById(inFu.getInvestorId()).get();
//		Fund fund = fundService.findById(inFu.getFunds().getId());
		Fund fund = fundService.findById(inFu.getFundId());

		if (!inv.getFunds().contains(fund)) {
			inv.getFunds().add(fund);
			return investorServ.save(inv);
		}

		return inv;

	}

	@PostMapping("/removeFundFromInvestor")
	public Investor removeFundFromInvestor(@RequestBody InvestorFunds inFu) {

		Investor inv = investorServ.findById(inFu.getInvestorId()).get();
//		Fund fund = fundService.findById(inFu.getFunds().getId());
		Fund fund = fundService.findById(inFu.getFundId());

		if (inv.getFunds().remove(fund)) {
			return investorServ.save(inv);
		}

		return inv;

	}

//	@PostMapping("/addHoldingToFund")
//	public Fund addHoldingToFund(@RequestBody FundHoldings fuHo) {
//
//		Fund fund = fundService.findById(fuHo.getFundId()).get();
//		Holding holding = holdingService.findById(fuHo.getHoldingsId()).get();
//
//		if (holding != null && !fund.getHoldings().contains(holding)) {
//			fund.getHoldings().add(holding);
//
//			return fundService.save(fund);
//		}
//
//		FundHoldingsPK fhpk = new FundHoldingsPK(fuHo.getFundId(), fuHo.getHoldingsId());
//		Optional<FundHoldings> fundHolding = fundHoldingService.findById(fhpk);
//
//		if (fundHolding.isPresent()) {
//
//			fundHolding.get().setQuantity(fuHo.getQuantity());
//			fundHoldingService.save(fundHolding.get());
//		}
//
//		return fund;
//
//	}

	
	/// --------------------------------2 Ok
//	@PostMapping("/addHoldingToFund")
//	public FundHoldings addHoldingToFund(@RequestBody FundHoldings fuHo) {
//
//
//
//		FundHoldingsPK fhpk = new FundHoldingsPK(fuHo.getFundId(), fuHo.getHoldingsId());
//		Optional<FundHoldings> fundHolding = fundHoldingService.findById(fhpk);
//
//		if (fundHolding.isPresent()) {
//
//			fundHolding.get().setQuantity(fuHo.getQuantity());
//			return fundHoldingService.save(fundHolding.get());
//		}else {
//			FundHoldings fh = new FundHoldings(fuHo.getFundId(), fuHo.getHoldingsId(), fuHo.getQuantity());
//			return fundHoldingService.save(fh );
//			
//		}
// 
//		 
//
//	}
	
	

	@GetMapping("/getFundHoldings")
	public Iterable<FundHoldings> getFundHoldings() {
		return fundHoldingService.findAll();
	}
	
	@PostMapping("/saveHoldingFund")
	public FundHoldings saveHoldingFund(@RequestBody FundHoldings fuHo) {
		return fundHoldingService.save(fuHo );
	}
	@PostMapping("/addHoldingToFund")
	public FundHoldings addHoldingToFund(@RequestBody FundHoldings fuHo) {



//		FundHoldingsPK fhpk = new FundHoldingsPK(fuHo.getFundId(), fuHo.getHolding().getId());
		
		FundHoldingId fhID = new FundHoldingId(fuHo.getFundId(), fuHo.getHolding().getId());
		FundHoldings fundHolding = fundHoldingService.findById(fhID);

		if (fundHolding != null ) {

			fundHolding.setQuantity(fuHo.getQuantity());
			return fundHoldingService.save(fundHolding);
		}else {
//			FundHoldings fh = new FundHoldings(fuHo.getFundId(), fuHo.getHolding(), fuHo.getQuantity());
			
			FundHoldings fh = new FundHoldings(fuHo.getFundId(), fuHo.getHolding() , fuHo.getQuantity());
			return fundHoldingService.save(fh );
			
		}
 
		 

	}
	
//	@PostMapping("/removeHoldingFromFund")
//	public Fund removeHoldingFromFund(@RequestBody FundHoldings fuHo) {
//
//		Fund fund = fundService.findById(fuHo.getFundId()).get();
//		Holding holding = holdingService.findById(fuHo.getFundId()).get();
//
//		if (fund.getHoldings().remove(holding)) {
//
//			return fundService.save(fund);
//
//		}
//
//		return fund;
//	}

}
