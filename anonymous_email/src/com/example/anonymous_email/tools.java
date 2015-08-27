package com.example.anonymous_email;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class tools {

	public static String getExtension(String value){
	Map<String, String> phones = new HashMap<String, String>();

	phones.put("aircel.co.in", "Aircel");
	phones.put("airtelap.com","Airtel");
	phones.put("msg.acsalaska.com","Alaska Communications");
	phones.put("sms.wirefree.informe.ca","Aliant");
	phones.put("sms.alltelwireless.com ","Alltel (Allied Wireless)");
	phones.put("paging.acswireless.com","Ameritech");
	phones.put("ideacellular.net","Andhra Pradesh");
	phones.put("text.aql.com","aql");
	phones.put("ezweb.ne.jp","AU by KDDI");
	phones.put("txt.att.net","ATT");
	phones.put("txt.bell.ca ","Bell Mobility");
	phones.put("sms.bluecell.com","Bluegrass Cellular");
	phones.put("psms.bluesky.as","Bluesky Communications");
	phones.put("myboostmobile.com","Boost Mobile");
	phones.put("mms.bouyguestelecom.fr","Bouygues Telecom ");
	phones.put("bulletinmessenger.net","Bulletin.net");
	phones.put("cbeyond.sprintpcs.com","C Beyond");
	phones.put("cellcom.quiktxt.com","Cellcom");
	phones.put("mobile.celloneusa.com","Cellular One (Dobson)");
	phones.put("cwemail.com","Centennial Wireless");
	phones.put("sms.cvalley.net","Chariton Valley Wireless");
	phones.put("airtelchennai.com","Chennai Skycell");

	phones.put("rpgmail.net","Chennai RPG Cellular");
	phones.put("139.com","China Mobile");
	phones.put("gocbw.com","Cincinnati Bell");
	phones.put("cingular.com","Cingular (Postpaid)");
	phones.put("cingulartext.com","Cingular (GoPhone prepaid)");
	phones.put("clarotorpedo.com.br","Claro(Brasil)");
	phones.put("ideasclaro-ca.com","Claro(Nicaragua)");
	phones.put("vtexto.com","Claro(Puerto Rico)");
	phones.put("sms.cleartalk.us","Cleartalk ");
	phones.put("comcel.com.co","Comcel");

	phones.put("sms.mycricket.com ","Cricket");
	phones.put("number@mgw.mmsc1.hkcsl.com","CSL");
	phones.put("sms.edgewireless.com","Edge Wireless");
	phones.put("SMS.elementmobile.net","Element Mobile");
	phones.put("emtelworld.net","Emtel");
	phones.put("echoemail.net","Esendex(UK, USA)");
	phones.put("esendex.net","Esendex(Spain)");
	phones.put("fido.ca","Fido");
	phones.put("smssturen.com","Freebie SMS");
	phones.put("mobile.gci.net","General Communications Inc.");
	phones.put("msg.globalstarusa.com","Globalstar (satellite)");
	phones.put("ideacellular.net","Goa Idea Cellular");
	phones.put("gscsms.com","Golden State Cellular");
	phones.put("txt.voice.google.com","Google Voice");
	phones.put("hawaii.sprintpcs.com","Hawaiian Telcom Wireless	");
	phones.put("ideacellular.net","Gujarat Idea Cellular");
	phones.put("sms.haysystems.com","Hay Systems Ltd (HSL)	");
	phones.put("myhelio.com","Helio");
	phones.put("ice.cr","ICE");
	phones.put("msg.iridium.com","Iridium (satellite)");
	phones.put("iwirelesshometext.com","i-wireless (Sprint PCS)	");
	phones.put("mobile.kajeet.net","Kajeet");
	phones.put("msg.telus.com","Koodo Mobile");
	phones.put("text.longlines.com","LongLines");
	phones.put("loopmobile.co.in","LOOP");
	phones.put("m1.com.sg","M1");

	phones.put("ideacellular.net","Maharashtra Idea Cellular");
	phones.put("sms.mediaburst.co.uk","Mediaburst");
	phones.put("sms.mymeteor.ie","Meteor");
	phones.put("mymetropcs.com","MetroPCS");
	phones.put("sms.mobitel.lk","Mobitel");
	phones.put("sms.movistar.net.ar","Movistar(Argentina)");
	phones.put("movistar.com.co","Movistar(Colombia)");
	phones.put("movimensaje.com.ar","Movistar(Spain)");
	phones.put("sms.co.za","MTN");
	phones.put("text.mtsmobility.com","MTS Mobility");
	phones.put("my-cool-sms.com","My-Cool-SMS");
	phones.put("messaging.nextel.com","Nextel(USA)");
	phones.put("msgnextel.com.mx","Nextel(Mexico)");
	phones.put("docomo.ne.jp","NTT DoCoMo");
	phones.put("mobile.celloneusa.com","02(USA)");
	phones.put("sms.is","OgVodafone");
	phones.put("orange.net","Orange(UK))");
	phones.put("mobile.celloneusa.com","Orange(USA)");
	phones.put("ozekisms.com","Ozeki");
	phones.put("vtext.com ","PagePlus Cellular");
	phones.put("api.panaceamobile.com","Panacea Mobile");
	phones.put("zsend.com","Pioneer Cellular");
	phones.put("sms.pocket.com","Pocket Wireless");
	phones.put("mobiletxt.ca","PC Telecom");
	phones.put("qwestmp.com","Qwest Wireless");
	phones.put("txt.att.net","Red Pocket Mobile");
	phones.put("pcs.rogers.com","Rogers Wireless");
	phones.put("email2sms.routomessaging.com","RoutoMessaging");
	phones.put("sms.sasktel.com","SaskTel");
	phones.put("box.is","Siminn");
	phones.put("smtext.com","Simple Mobile");
	phones.put("sms.smscentral.com.au","SMS Central");
	phones.put("starhub-enterprisemessaging.com","Starhub");
	phones.put("rinasms.com ","South Central Communications");
	phones.put("SpikkoSMS.com","Spikko");
	phones.put("messaging.sprintpcs.com ","Sprint (PCS)");
	phones.put("page.nextel.com","Nextel (Sprint)");
	phones.put("vtext.com ","Straight Talk");
	phones.put("gsm.sunrise.ch","Sunrise Communications");
	phones.put("rinasms.com","Syringa Wireless");
	phones.put("etxt.co.nz","Telecom New Zealand");
	phones.put("teleflip.com","Teleflip");
	phones.put("email2sms.routomessaging.com","Telstra");
	phones.put("msg.telus.com","Telus Mobility");
	phones.put("esms.nu","TellusTalk");
	phones.put("sms.tigo.com.co","Tigo");
	phones.put("tmomail.net","T-Mobile");
	phones.put("txtlocal.co.uk","Txtlocal");
	phones.put("utext.com","Unicel");
	phones.put("viawebsms.com","US Cellular");
	phones.put("viawebsms.com","USA Mobility");
	phones.put("viawebsms.com","UTBox");
	phones.put("vtext.com","Verizon");
	phones.put("viawebsms.com","Viaero");
	phones.put("torpedoemail.com.br","Vivo");
	phones.put("vmobile.ca","Virgin Mobile(Canada)");
	phones.put("vmobl.com","Virgin Mobile(USA)");
	phones.put("vxtras.com","Virgin Mobile(UK)");
	phones.put("text.windmobile.ca","Wind Mobile");
	phones.put("sms.xit.net","XIT Communications");

    for (Entry<String, String> entry : phones.entrySet()) {
        if (entry.getValue().equals(value)) {
            return entry.getKey();
        }
    }
    
    return "";
	}
}
