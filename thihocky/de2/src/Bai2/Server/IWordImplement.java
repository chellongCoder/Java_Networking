package Bai2.Server;

import Bai2.BEAN.Word;
import Bai2.Registry.IWord;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project de2
 * @Author chellong on 4/1/19.
 **/
public class IWordImplement extends UnicastRemoteObject implements IWord {
    private List<Word> listWord = null;
    protected IWordImplement() throws RemoteException {
        listWord = new ArrayList<>();
        this.initData();
    }

    private void initData() {
        listWord.add(new Word("KMA", "Hoc vien ky thuat mat ma"));
        listWord.add(new Word("IT", "Cong nghe thong tin"));
    }

    @Override
    public String shortToLong(String shortWord)  throws RemoteException {
        for (Word word :
            listWord) {
            if(word.getshortWord().toUpperCase().equals(shortWord.toUpperCase())) {
                return word.getlongWord();
            }
        }
        return "khong tim thay tu nay";
    }

    @Override
    public String longToShort(String longWord) throws RemoteException {
        for (Word word :
                listWord) {
            if(word.getlongWord().toUpperCase().replaceAll("\\s+","").equals(longWord.toUpperCase().replaceAll("\\s+",""))) {
                return word.getshortWord();
            }
        }
        return "khong tim thay tu nay";
    }
}
