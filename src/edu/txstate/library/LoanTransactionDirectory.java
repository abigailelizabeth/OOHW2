package edu.txstate.library;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.ArrayList;

public class LoanTransactionDirectory {
	private static LoanTransactionDirectory instance = new LoanTransactionDirectory();
	
	private ArrayList<LoanTransaction> loanTransactions = new ArrayList<LoanTransaction>();
	
	private LoanTransactionDirectory(){
		// ensure class has one instance
	}

	public static LoanTransactionDirectory getInstance(){
		return instance;
	}

	public void addTransaction(LoanTransaction loan){
		loanTransactions.add(loan);
	}

	public void removeTransaction(LoanTransaction loan){
		loanTransactions.remove(loan);
	}

	public void saveData(){
		//implement this
	}
}
