package leetCodeTest;

import java.util.*;

public class 拼写单词 {

    public static void main(String[] args) {
        String words[] = new String[]{"jdimdfzbygjgdrsisgblztowvwzewvrwuizaihnctoonlykrbzncqvbzjahxvyswdzcbwaqliiyzbddtsxrwb","ybdhccgznflezzvifoshbatwedohwwhyajylprerarbsjcll","febacfxkrwnkyoyhykzbfuueohtkvqjkrmclmiinmpwhumaummpxjqmvqnvlwkmiizewfnqnmjqmnxacrhgxodyglvzyyii","tcymwrytgfnbggzqptaqwzpkjhleisuwsfzhna","rdvuvrrqerihadnurdfkzfiwtodnzcwvrmuwkyjhgkdjtnuwlclnhttidukyhfdzozix","mjoryzsbvkqlmtmcmsjljloabfaliecpmmiumq","iwzpczbknmqrankiypxjxthlzsvhchpqv","dqpgxyspa","igsvidvyonqyprvkoaphuvqaxcceefckypojgfdiyubagihkztnhindjcdpolt","iamvwzvdbfonuurfdzcnvohqrpyxgmjvbyiyovvccsilkblgpojmwvhdsewldgzvdlnecfudjjkmgmil","lbtjpakidwtavvtllcpekgcmqigmrfkvfjyzbxlpxtnklqrfoasnocjnlhzafcjqdjqgmuardsifyrlkvrndat","tfqdhgvduounzgbdnipofenkqzqrlntcppwkk","dwtuwpqugxvkjnhxvpxsdxyeurkldhxnpmicxmntiokhcclptbbbamzcrwachvzi","pdnmdakvxnwdmibwqclesycgomztyowtjskvwiwuaumwubrmkli","sxabmaciwtbbtwwawfhqisthjqxsxslsptcxqgsrzxiirxmzzmoulqmwzwatkrjqgpelkenulstuxwzjno","enhtapuuyildahjyryubmjqdhbtfhjzhwppqbzriytu","momfgjhyxzpsp","hhdyxizwufxjewqvbforsauqgexpqgrhbmycwcaxbwldljuhclpyfawbhypinsfjepgded","cgowwwhvlaziuptfsxqygxxnqxbregcwaodyklkkywpdtofrupmeeaeoemmpdwltdzbvebuzfumfdbdqu","xspywgpzetvfdzeyterumsweldzsdarwshssaxlfgqqlckcyeealjqdfkjdncoivvgkmcvaod","ubuubimfvxvplgikclwilovjdkns","luzrzwfwzlunkwlvpjqpwckboxhgufsjlpmklxxtiuvlvaydkdvqumhiospabiemygntpfotocufttzzewkbxf","mqqktykhjxtebccvpwttybgvkkxndvxfagdnjmbezlmdgw","opcobbidwttpeisekgmowtgcozeinvfliqbkbrtkvwxdobavjyrknsadjijwybtbayfytxeotfp","c","cefqqjft","ijavryhszfeevxvrcubkvpobxajzfjhnyffkdnucigmisvalwfngwahy","pzfkcxeehzytxrtbdqqcoaccnqiynsjypfrcablnznvmthga","tlekyalvnyxsvr","jsahgkicszfcheyqafvflufycicegxclqpbmvmakjbhtuwhcxerxwspgzsrubfqblbhavlwfhx","tvzrvrsnjetkoxbliawcvzzakpmhhvnjubczcpgobuqjqffsrdxtxjarzgsuryajuatcyfbroginvjhlauzbrkhssf","dqbrdlmkhkrdzecilmfuavrphuxbqjo","pmdpypebaobezmcfazewjbabjqjvrefyravwrvneyfpesbwnbbymuvovjvqgfwmzcsweifbpkuzicpjsj","wfobqlvkmehlrh","soormzqclvrrhftinorqqtfprxqufqsadalczqgbdnirkohqvzucsuunzjvbcfrryzztgy","lfpvzygoenywdaddtsnrtmdhqnrkuyydwbwmzbwxzmoxwxvyttomlqdsekhyoaltxjhdtggwxrueelgh","sikbegcpidcsnbierikpueovdqaxzis","bchfnjcxqkfavrpotyghvhdzfsnigpgeuen","igcpbhexbrhqgvzbjuvgehqrntbdfluouysupmtykobvkxzhumwxtntmbnyditvjmgoqtbiabkzfx","xlgxysycbrskihoxiolefjhgdluugsuvvlhxlbqxzcqgqoxrmhmrylpfbarrplqgpvep","oivjponqitutsacujnlmwotbeinwfygnzdzqet","yktuffealtkznzvccxuzejpruspfldidkheondsmdbgwrabkmwgtbguayqhyiynfjfqgbpxoizlhottxeqbauj","sxghynxeletecuqbafmqmlmiwlaenuujfipfkeylcyfjxkznpkc","gxekcfwgn","zitnbxgfpnzdoaahksuajugypfdlzwzadmksgtuqoevnqjkwoybabozgovuzlazwlopcuofwnqpkcpyupnh","oydlvwonusmqypnlpwhdakzdoft","kphotdvwvjypd","cdcwreimmvstaytgnlwrdzumkilseqrorlsgzmmogjixszokypjalqmexhjesknsnpgjowypsno","bbfbbepyutonbnmtbmmdrgxnhoifxluendcayelykgoglnrucegkhoczbajaobdggmusdbdllz","tmelbseagubuvjjvpzkyvbxcyxzoxjvhcqwmesdwi","twbedagexfuyyghuqxgwxmtbckchmiknghoaswufihzcmcdkyiqphjwpgpqsavoiiejfoqoucmvcahxmshu","aqnipfzpclcsyuecagdfho","cfcigrykqaeclkckntqkioexxvzvqfyirgqiwsbamtigxewdgpbhxsrwiofxzakvofqzbznbkfpfqpnns","uoyzgkluftocnmbdrpyrmaywyyevbfcebzfxqljgigcgfmoeznqpkbmiwmziqlmdealiknlfzdwbadyjunth","pniwsxvfxlsfhkhijuwcdvzahgzjmxdjpggcmynlfeitrggpgfudhfsswqaxapmkalrmiikrdcqyovqqyiasc","hjoff","zchyafrvstjxrpcrjtxrzqtgemtnbioizjvrsbmmwsqfcqtovk","rqopixeyjdtwekhdilymtmbvpllrbcfkfojwyzgvhlhxvflywzqiiqlnwooudmwjtfikdgecxsbwxnmmyaxkqyxbqsgn","jrjjoqkpqfjslcklltztyhkmrqmlmvjczidsswyhmyowxuunogxomhxtireakdfheffjaarcmonvxxuhvlnpujenrvjpsdrngsif","oluqeooumhfdizvbmzzxznccypdfqeibvhhbbknqcvdryuiqzmheivglczcxcneypm","odiyjnibfvnmojenjmtnawnnsatslheoqliyqtsmrxojxlsqep","xodhotsxujcannmgvmszwnpvlyxrvfntk","pal","pfuaarkhepsjjtljpdhne","cmravobrplecnohwhfcxbgsmkqkqjmdrpz","rhwlfbsjnoileeuatpwpzxsqssfxbakasvvhrnfvsnji","cprpqsoavnarqcyjhuxeeapjwkbrignbhgkufpdbentazdgfrjksrmbvcbwypcrh","ouxsbfsvuihlhjcsiccibxvxtpwuzhrthhotbinvclelxhujtxqnpzoylzatzgdvawmfjwychqeopcrdjnejdtfkdign","zhoel","jwcdwcwlljltoiepktkflngdsqeagqwowkbopjzwbruhzntusrixinwvf","amn","zpcniceupkondvpyjbckasmevmoxquumalzrnhpxskxugik","cvefdfpkcctzpipaodrygoaoesgvihhhthygs","bkohexejlvylwkrykmmcgcf","olpytsjqlkdpwi","qsidlbvlccnjtyrupfxprlwhcynoyxlbrxjojkiqrsawbaumnzkdkzchommc","ixnpbwnjtpqczoybczviqfbjtuxjdibzgispvxdnjppranzldirjcxut","zlzvegbitlzahbmkectimwpbaletlxpcotygzvwridoiswxiuawtz","fhptimdesuoqzjiblcwnhhbaxptzraksykvfpunxfufrwcmvqnwjocoiy","aiyorgqnkvdopapcjpenkymhnynpkzyntylozbydnpibdrpbvcutpxudrcsizoyk","nmuyeikwomlcripugwjypkfvbvizvrmndhsacmdocjjdhtnqvuxmgrcfeczuxsa","geulhswpnmyweuswggltxsguxnnvecovqxvteiuadxgdksmjtitwcpzmbxicwvclkndttsduxb","tbdazbskpejjkquorhfdafdvlgglefjhqguriqaefpvhcqscfhtvkimqvjzxtaf","ldnnyerfedgsffdhpbmbwuubrzsjibafxqccryuljvusadrlfxqw","meylutslakssulbpvfonrfmvugblinwzrfgopxafnwwdcuufjuaimxrbheehjndxbiohskmvjrmpcewvvvrbaqbkfffgbb","ygjmeswiarqiwkpuzjsfnbabtvgapaoazzkuafcpuuavzmvvhcnwedpgbizznkygooedxjggbdkrgkcyaautpvwwnvlfwikyl","mjgnewabmklmzwazyhcdoyqowpgrdcnuzwoha","nljceveqjwgwmylmbgkawzjdvueoglyxdbpdyqpgwgtmixlkxphtltijcm","maunpmlrxvreydzpzllevzlxpbkeeyrsskuhtklrnmpytaugdnuvgotmptgprsfcrcenxg","wxqdzhmffyesnlbweaipjgjojsvvfmyyrsxjuqgyseuojmsemhgxalbbdiepwbizkf","ricbkdxnkujtlgnuzcx","gttdwdoclpkcejljedytqilnrpgsphfetbxztwihmhhspvyfdtbavl","srmlsxsnohyy","lpg","qpmfbycwecpgnthstqwcdwrfxlykjteonfqvgqfxgyjmnqfh","guojktcpspmbtsfucyze","uhkpgnmkewkhymqyfzxbb","qifzafbdvmjgfmzdotznlbzsllakihgzdpmwliwmmyoyovofyhxupehqjryccvzsejvnfebbyaxtwji","xifotcwgywruiymsgmkamaaqnawvooilhqflxptbiewtzcufqvlldsxapunlbbzurwlegvspxhkjnivmeuxu","ewpkblzobahkxvmaorqxotmlszkjlnbbqhgfeoymxntpsilzzmgknzkpgwanlajbagyxdaxvgg","xuxovygmkcyukmtsfwquiw","otvowenq","thfd","upypegljhttngfmnrwoqunnysvaauywjppaqlqayfcpajnirjgwjmaeyfpkexyfhdztctsctgfyoyi","pypgyhubkosgpcsiucjvocobhfiayxjydpjakwpduaybk","zskfzaqcegxmcxjyyraaaskmurewhpdgeccdiqdruevkipfynevvgdwpmevxolczrssveyf","qazabogdtspviktvigfumcliotxzlfgqdmnwnejdyuiaxdrhjpzpodjmk","qozbqbokeous","gwlvoonxjrhvzyqmnlwfykqex","uaumnvenxonkofoquxkbevxhinefttwiymaeecwzlknmzljzcldmmpekrnfdql","xzrghwbgmljjbboonroxerqkbuygiouaylhkdauoagnizfndqzabdbycwa","wrmcoohqyiwguwxntxlaxlrcambhvughnujvqxtvxuiyvvbgdsqukkdrprcxk","kajvhekqzmmolchwsnhwsotawzndwpoxxcphjxvjhwyqhzffyilcvwin","osnjdwvjwtqplvovigvmkkuvzvyrnqbfpliyhvtbquiyucvfxzrvupjsaxisiqvdvjuavclfmbeddvype","aa","hzvczfzpteogbzckschfxooyybkkyodaoncwlfjrrozjedbniwhmrxbxgvsknpjtntia","mnsplhfonlxqrfaoiqbroqrtvjdurciceuyazjslbxkznbjsaaiaiumshqmcdjrzkzkxskoiacnlwuumchanvp","y","llusbfpxolpcuxqlxsxusxljtvzoaukhebnimpaczhdgtlpdzmmxvqi","cxxpgjxrfajufcyljmtomctdloifssgmqpdxnvnojtbczsunjirzmpavidwgvcrwioubusmrprda","elyrktioorsgpmdogctdzoyumidyhkrcxjpsnqcjzqacpzsockdmpbobd","cwklazpkfcycsdfjmjryxlikfpcjnjvjwckghqzhgcyhrfbfetmbakpnzjuvgmfngqluuxqvgprdmcclrdwkazvjciecidp","jxgoqngvvdqgfzdtnlppzlpyxissnjpbcfvvdlzztbzspiwfglqbmvvqnpiscxzdmclnervesecqyyuppzeqnfzpddjn","itprgrhysrwmhhaawatgzcoifzidwsmbubyigwcewvfsxipilgmyjoabnhovsr","sdvroatgoiowdqxcchbkxuabrrxqrwqwaamebflbubghhdujyvjtrqjhs","lcizmwl","zbycvvwywvprknqomewgnukldcvzehmailqnpabcehjrsespzmcchlfiutwqhlcgvwwzgftqnsmmlxdot","ycfajupfdilekjptftutzfultpjrupvajbtphxuxjacorflgh","voeqeuorsrbostmivapuxevtmilhzxpeswivyiqkflxgdwpdieptpvplailynqsakhfnoluw","qhaqtselyauycemuspozlctffeurfclumidaildhczgorkrvydqcraxhstswypcjktjzyijgbmozwfk","cifmzmjvtuwzrvszvlkrfbxdztjtwttqxvwtrrdflwraygcnncq","tqwdkiowbbeobixyurrlgzejkvrgpatwdfbkmexu","qmohzsrkypncpinlhthrrjgalqhemwdliueqrnqbjqk","jmuafzdxuyawoopckcihbgibuieaipjjuvelngmdwyhkthoeslmatibnxkexgiasuemzbbagijhuekilhguanvsi","mcfttopijlwyiqjfddidkbrrznxiggspgrzv","wkmpshoyvpcavisaluywwuxwggyguwyrewlsdxuhomkcipelifkzyremrdqnxriaddpzpqzfvdwyiuhkiyxlekpskkzawv","qhcgluzepldgtcsyfquniwdy","sqoxryxxgzqsjclmuvqiqawuidtihogggxjfzkniqjpyjwatpmecziomfgdkis","istjakvtyzzaelduexpmnthzwgkwnhqtfdblilypkxirpnlnqrsjffthjdtbfwhxueboquotzvccnexwcre","lrydfbliheallvpxasjfjfzeehxkxrgabcofnwetcjueolpgexetfieksdkeopci","tptyttbimmijjnbciadfkwspfofbufpjuxcxylcbfdzoiqtsybxehtrryakqyptjkkkcsiqboreoiovoekelnx","zavzklwqyzokxnunkhjylukjqcsrvlkuxs","rtqyhcfhucrqadultzlumazicdu","ohobdcictit","xfganyznjxztlenimrljgyifwypjvmcxmjpdwfgspiyoyjetbrtrtxktiobhnzts","fuvsdvoviyyzqzxliebnxpawtmczyiylnzvbyfilmbbgjoseyxbqawi","kqtwdwcgtbgzmzejvskhevbokzdvomkawvqmsfwdhbnqdxlgy","eplegvqtvywmbqtndpdcbbylonvowepnneqlywrtnryudbqorjasivuwkszxzfwqdqozrbubjuovkxehkenmlorvavznwoxbbj","qjlynqakaxhvmbtzaymetjsilvmxfxjnlspufjxffwksiuyztzklwzvocatawrewicebujfgpq","mghamvubjtiuviceyccpejehmumtaeejraargsbvfxsgbhigjejuvreuvgbjtzbrzmsrsgjhblzqoz","zzvkiqrtyfssalidbudmgpjadfnvewcjxxeizrrkv","wrsegnaznxixzhyhdmslgcgslrcmyvclh","fujynwgcgocsbkzuvvppknspbvnitwbxnaf","lihsicgcjuablnfflwuwifcrfwiioafxxbbqwgzibnwhoxzhvmhbgjafvcumjgthiqiuacojuycejodzghucnpogjyykzitugkcr","wibifkhjooviuxbpucnreszrshiyfgcfywfncxiaodriejwrkskkwlgwxmzkrzfz","pgmogxujiwkgusbriztdkzkoirswmxwmjjeomcbzg","xzoksdragbjecrmropprjbtglqcsxzxaxfthhlkrcshobyisrlv","gfgfhiljcgckutrrectpweexqmqntccqekojlbxsnvmkiareesbazlgsmunbagbmurgwzmb","kldgnhosnhqdfpplqbpujzcpozokvyopbasgvkcevcwsrxjpgaksxybqsofsxzsdeflphvzpzqioflitssplfheepdraeketdj","lrkykfzbqohzghvriwmwrtgptfdgwoclaehxujswufkmmuebvtozbhrjtpcmrwufrsjupoedgqsubbbvlbtkosrfdthrxbcq","cuvkc","qomgdgmepyktyexunnhirbqnarfdf","rmvppwtfmeteylqons","vdiqiavnkoxxqazrphttqhlevygfylfiyjkbmk","nbeawufkicbfhwdohjmhalwxvnexleiarewaklpyrleygvqftnmtwhpxcbiajearbckhydjstlvwfeywdwcu","fnwwldvonsrbqyfwecjclbodmzrgydejnsbshzbzosptoyugmvizkupntxffjzyijcjvnxhuzez","imqfboyfcmbzjduerhkitmpopdaroi","cukchstrkftlgefvyzpsujetytoebujmhwkipdgizdkipjcpvzzchqqrmqylmcszvemjbzgketpkzbrxguanvjbpxok","bvyuoyqyryyeviocouoxdckpotoaklhalkxppvxwvzaxwh","hkjlnprhizooehppsjxbsrbaxyuszevcukvoqffczvonstjiinxtwgzngctnkpbrpeohbxemlcjjgdlcvtfdodpqavcxftmnczk","twzzzushasnqjxzfdtizajegksbhljakizojgausnhkxdfrypiriwmrraqnrhloctrvukkqons","bizlpbpvdkcbcavxogrkaxmzbsujecqphusdxlhprrfokhbkgeapghdclkfgutfhkckoozolsyequrgnrndybvofuzca","uhlgrpshm","fffblhiue","uxfxwhhhzwubnpkshnetkvmokzsnalh","xzbqhsjmkkxkpreqdrooiifvkrxquxwlpytwbmespaqdknxcwfhnjesuwdujghoxznrlxelmi","ljbdlnpjvzbiywyjqmxdxbqiwqkkvqslfklugpzithhviczc","kqhattassqwlrxhpzaytmazlyfgvbglxgiqnrrghdjoclhhleqqlwdeblsviwkciqehcjypozryajlngeqrloxufpuryncat","kyptacgghycdhhnhmlndjaqsrtjudnhwixqvuamkaguagzacczyirfqarfuklvjf","tsuinonhxpreonbxzaztfeffdcymrxngqeuthmzojldodqlhpxpremc","bvejqokgmvsxfugorsldmalka","fxlloyqelywmhiwdtxvtttddthfzbajrgeznmxxgmwzvtmnnwjebeylwjspxygveswxtzefrfhlyhyyambt","wuhqhyxfpsoaoyssbjwjxqzhckfyfsvonlmyphloyoagoxycirdriaramwxsrswbxptxzvdjticaacwnx","vtgnhypjamsfxyvnzghqrmntherndth","fmavnsloegrtcibrbifuibqvjvusppgmprqmibm","prfyttezajzqbcccrhqdevnazibcpznkxouwegpbbapxlrmhkfhoihv","hoaerkgvqbhssdrujbrtmlvwbnhqx","ozerhqqdwfwduyxrjmtxrevbdtgmwpbhkxqjsnlssmestosukzlglqdfi","gthdnp","nukyujeknoixksgludcsmxbbsrqjbpnbtvuawtbihdo","xflmwpjo","eb","uujqhzyytjv","jgowebswpjsggcahajdxzlratrocfghnplpkabnzitmhfhwspgshvpamgqpilgortzvzuoexbaxcalxsxlzsdejgjgihulwxoabq","sytmzzwifklxsrpyldonjbqchisdjfhpmhzjea","eithdxqoyza","sqozuxpdhuaqttpwvyilgjtrtttlmeabuxacxhhjmxfpunzdmxeghuukyutlfkk","njsirzxawbzktvdyrhxzjkqgnipmjffsabonsdmkinjwqhmwngwcravsctcuglkk","dmbkpmbvcklftvucfzjfagowavptxbezhrnkrvnfhauhfrdnfnxuneznqnjlwxxyhfcxrq","cwdnifexgdpqqecqwktngwzqtqvbcywdphfxfnzoavileuflvkcnzirqdkpulrvmgjrqjblwfjdqacmwzytcqrxrspmlleolt"};
        String chars = "owqugdlpqrnasodvbemfhuzctbibeboxgdklfyzyucomprzzoxwwxm";
        final int i = countCharacters(words, chars);
        System.out.println("i = " + i);
    }

    /**
     * 思路三：
     * 93%
     * 有以下注意的点：
     * 1.使用字符串数组记录字符个数
     * 2.使用flag变量控制是否包含该字符串（好像在哪里看到尽量不要使用label这种跳转的....）
     * 3.如果字符串长度大于chars，可以不用比较，直接跳过
     * 4.可以一边遍历目标字符串，一边比较，可能会提前结束，不用再用一个for循环。
     *
     * 作者：13217319563
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/solution/javazhi-xing-5mschao-guo-93-by-13217319563/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        int len = 0;
        char[] cs = new char[26];
        for (char c : chars.toCharArray()) {
            cs[c - 'a']++;
        }
        for (String str : words) {
            boolean flag = true;
            //如果长度大于chars数组,直接不用比较
            if (chars.length() < str.length()) {
                flag = false;
            } else {
                char[] temp = new char[26];
                for (char t : str.toCharArray()) {
                    temp[t - 'a']++;
                    if(temp[t - 'a'] > cs[t - 'a']) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                len += str.length();
            }
        }
        return len;
    }
    /**
     * 63.5%
     * 思路二：
     * 我们既统计“字母表”中字母出现的次数，也统计单词中字母出现的次数。
     * 如果单词中每种字母出现的次数都小于等于字母表中字母出现的次数，那么这个单词就可以由字母表拼出来。
     *
     * 如何实现计数结构呢？一般的方法是用 map，比如 C++ 的 unordered_map 或者 Java 的 HashMap。
     * 但是我们注意到题目有一个额外的条件：所有字符串中都仅包含小写英文字母。
     * 这意味着我们可以用一个长度为 26 的数组来进行计数。这也是很多字符串计数问题的常用技巧。
     *
     * 作者：nettee
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/solution/tong-ji-zi-mu-chu-xian-de-ci-shu-shu-zu-ji-qiao-cj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param words
     * @param chars
     * @return
     */
//    public static int countCharacters(String[] words, String chars) {
//        int[] chars_count = count(chars); // 统计字母表的字母出现次数
//        int res = 0;
//        for (String word : words) {
//            int[] word_count = count(word); // 统计单词的字母出现次数
//            if (contains(chars_count, word_count)) {
//                res += word.length();
//            }
//        }
//        return res;
//    }
//
//    // 检查字母表的字母出现次数是否覆盖单词的字母出现次数
//    static boolean contains(int[] chars_count, int[] word_count) {
//        for (int i = 0; i < 26; i++) {
//            if (chars_count[i] < word_count[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // 统计 26 个字母出现的次数
//    static int[] count(String word) {
//        int[] counter = new int[26];
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            counter[c-'a']++;
//        }
//        return counter;
//    }

    /**
     * 思路一：使用两个map集合存储word与chars的每个字符出现次数，然后比对，如果存在字符出现在word中，而不出现在chars中，
     * 则返回0，如果存在word中的某字符数大于chars则返回0，否则返回word长度。
     * @param words
     * @param chars
     * @return
     */
//    public static int countCharacters(String[] words, String chars) {
//        int i,num = 0;
//        final Map getmap = getmap(chars);
//        System.out.println("charsmap = " + getmap);
//        for (String word :words){
//            num += compare(word,getmap);
//        }
//        return num;
//    }
//    public static Map getmap(String str){
//        int i;
//        Map<String,Integer> charsmap = new HashMap();
//        final String[] split = str.split("");
//        for (i = 0;i<split.length;i++){
//            if (charsmap.get(split[i]) == null){
//                charsmap.put(split[i],1);
//            }else {
//                Integer integer = charsmap.get(split[i]);
//                integer++;
//                charsmap.put(split[i],integer);
//            }
//        }
//        return charsmap;
//    }
//    public static int compare(String word, Map<String,Integer> chars){
//        final Map<String,Integer> getmap = getmap(word);
//        final Set set = getmap.keySet();
//
//        int i;
//        if (!chars.keySet().containsAll(set)){
//            return 0;
//        }else {
//            final Iterator iterator = set.iterator();
//            while (iterator.hasNext()){
//                final Object next = iterator.next();
//                if (getmap.get(next) > chars.get(next)){
//                    return 0;
//                }
//            }
//        }
//        return word.length();
//    }
}
