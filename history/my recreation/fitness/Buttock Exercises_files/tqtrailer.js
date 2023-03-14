//***************************
// Cookie code from 
// http://developer.netscape.com/docs/manuals/js/client/jsguide/advtopic.htm#1013101


function setCookie(Name, value, exp) {
   document.cookie = Name + "=" + escape(value)
   + ((exp == null) ? "" : ("; expires=" + exp.toGMTString()))
   + "; domain=.advanced.org; path=/"
   document.cookie = Name + "=" + escape(value)
   + ((exp == null) ? "" : ("; expires=" + exp.toGMTString()))
   + "; domain=.thinkquest.org; path=/"
}

function getCookie(Name) {
   var search = Name + "="
   if (document.cookie.length > 0) { // if there are any cookies
      offset = document.cookie.indexOf(search) 
      if (offset != -1) { // if cookie exists 
         offset += search.length 
         // set index of beginning of value
         end = document.cookie.indexOf(";", offset) 
         // set index of end of cookie value
         if (end == -1) { end = document.cookie.length }
         return unescape(document.cookie.substring(offset, end))
      }
   }
   return null
}

// 
//***************************

function ReportBack(Name,seed){
//  var number = Math.floor(Math.random() * seed)
//  if(number == 1) { //HTTP Week Report BACK 
	location="http://library.advanced.org/tq-admin/"+Name+".cgi"
//  }
}

function TQUrl(){
   winopts = "toolbar=no,scrollbars=no,status=no,resizable=no,width=182,height=168"
   tqDisclaim=window.open('http://www.thinkquest.org/tqfans.html','TQDisclaim',winopts)
}

function TQTrailer() 
{
   var seed = 10
   var factors = 86400000 // factors = 24hrs * 60mins * 60secs * 1000millseconds 
 //  var TQCookie = getCookie('TQCookie')
   var TQReportWeek = getCookie('TQReportWeek')
   var TQReportDay = getCookie('TQReportDay')
   var TQReportMonth = getCookie('TQReportMonth')
   var TQForever = getCookie('TQForever');
   var expDays = 7
   var expmonth = new Date()
   var expweek = new Date()
   var expday  = new Date()
   var today = expweek.getTime()
   var forever = new Date(2038,0,1)

   expmonth.setTime(today + (30*factors))
   expweek.setTime(today + (expDays*factors))
   expday.setTime(today + factors)


   if (TQForever == null){
      setCookie('TQForever',today,forever)
      ReportBack('forever',seed)
   }

   if (TQReportWeek == null){
      setCookie('TQReportWeek',today,expweek)
      ReportBack('week',seed)
      TQUrl()
   }

   if (TQReportDay == null){
      setCookie('TQReportDay',today,expday)
      ReportBack('day',seed)
   }

  if (TQReportMonth == null){
      setCookie('TQReportMonth',today,expmonth)
      ReportBack('month',seed)
  }
}

TQTrailer()
