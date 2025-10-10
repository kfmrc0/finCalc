public class Information {

    public static void output() {
        System.out.println("""
                \n1. --- Notes
                    This project was made by kfmrc0 for fun and for personal use. eventually want
                    to learn spring and spring boot for a web app with similar use or application
                    of this program. any formulas or equations involved were found on the web. in
                    my (Kfmrc0) opinion, this kind of info should be accessible and free without
                    any annoying pop-ups, sign-ups, or paywalls. thanks
                             
                        NOTE: using this program is not a form of financial advice. use at your
                        own risk. The user (YOU) holds all responsibilities and liabilities in
                        their own financial decisions.
                    
                2. --- Discounted Cash Flow
                    This section initially asks for ticker symbol and current stock price. The user
                    should then input a number of years of data (free cash flows). Then we calculate
                    the average YoY growth rate. Then we show this number and prompt the user for
                    a more conservative growth rate BASED on the calculated findings. Then we project
                    future free cash flows using the conservative YoY growth rate we got from user.
                    Calculates 10 years of this. Then we use those 10 years alongside a discount rate
                    or WACC and a perpetual growth rate (which is typically 2.5%, matching growth of
                    economy), to calculate the terminal value. Then we want to find the present value
                    for future free cash flows. Get the summation of all present values for ffcf's and
                    user will input cash and cash equivalents and total debt of company. (go on yahoo
                    finance). We also want the user to give the number of shares outstanding. Now, to
                    find the dcf price per share, we divide the equity value by the number of shares
                    outstanding. 
                    
                3. --- Weight Average Cost of Capital
                    weighted / discount rate, can use in dcf
                    
                4. --- Earnings Multiplier
                    price to earnings multiple, stock price and earnings per share. stock price / eps
                    eps * pe = intrinsic value
                    yahoo finance for numbers, balance sheet
                
                5. --- Dividend Discount Model
                    ddm test testtest tv val
                    https://www.wallstreetprep.com/knowledge/dividend-discount-model/
                """);

    }

}
